@file:Suppress("UNCHECKED_CAST")

package com.windea.plugin.idea.paradox.script

import com.intellij.codeInsight.navigation.*
import com.intellij.lang.annotation.*
import com.intellij.lang.annotation.HighlightSeverity.*
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.editor.markup.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.intellij.ui.awt.*
import com.intellij.util.*
import com.intellij.util.ui.*
import com.windea.plugin.idea.paradox.*
import com.windea.plugin.idea.paradox.localisation.*
import com.windea.plugin.idea.paradox.message
import com.windea.plugin.idea.paradox.localisation.psi.*
import com.windea.plugin.idea.paradox.script.highlighter.*
import com.windea.plugin.idea.paradox.script.psi.*
import com.windea.plugin.idea.paradox.settings.*
import java.awt.*
import java.awt.event.*

class ParadoxScriptAnnotator : Annotator, DumbAware {
	internal class ScriptPropertyGutterIconRenderer(
		private val name:String,
		private val project:Project
	): GutterIconRenderer(),DumbAware {
		private val tooltip = message("paradox.script.annotator.scriptProperty",name)
		private val title = message("paradox.script.annotator.scriptProperty.title")
		
		override fun getIcon() = scriptPropertyGutterIcon
		override fun getTooltipText() = tooltip
		override fun getClickAction() = ScriptPropertyNavigateAction(title, name, project)
		override fun isNavigateAction() = true
		override fun equals(other: Any?) = other is ScriptPropertyGutterIconRenderer && name == other.name
		override fun hashCode() = name.hashCode()
	}
	
	@Suppress("ComponentNotRegistered")
	internal class ScriptPropertyNavigateAction(
		private val title: String,
		private val name:String,
		private val project:Project
	) : AnAction() {
		//懒加载
		private val elements by lazy{ findScriptProperties(name,project).toTypedArray() }
		
		override fun actionPerformed(e: AnActionEvent) {
			//如果只有一个，则直接导航，否则弹出popup再导航
			if(elements.size == 1) {
				OpenSourceUtil.navigate(true, elements.first())
			} else {
				NavigationUtil.getPsiElementPopup(elements, title).show(RelativePoint(e.inputEvent as MouseEvent))
			}
		}
	}
	
	internal class StringScriptPropertyGutterIconRenderer(
		private val name: String,
		private val properties: Array<ParadoxScriptProperty>,
	) : GutterIconRenderer(), DumbAware {
		private val tooltip = message("paradox.script.annotator.scriptProperty", name)
		private val title = message("paradox.script.annotator.scriptProperty.title")
		
		override fun getIcon() = scriptPropertyGutterIcon
		override fun getTooltipText() = tooltip
		override fun getClickAction() = NavigateAction(title, properties)
		override fun isNavigateAction() = true
		override fun equals(other: Any?) = other is StringScriptPropertyGutterIconRenderer && name == other.name
		override fun hashCode() = name.hashCode()
	}
	
	internal class StringLocalisationPropertyGutterIconRenderer(
		private val name: String,
		private val properties: Array<ParadoxLocalisationProperty>,
	) : GutterIconRenderer(), DumbAware {
		private val tooltip = message("paradox.script.annotator.localisationProperty", name)
		private val title = message("paradox.script.annotator.localisationProperty.title")
		
		override fun getIcon() = localisationPropertyGutterIcon
		override fun getTooltipText() = tooltip
		override fun getClickAction() = NavigateAction(title, properties)
		override fun isNavigateAction() = true
		override fun equals(other: Any?) = other is StringLocalisationPropertyGutterIconRenderer && name == other.name
		override fun hashCode() = name.hashCode()
	}
	
	internal class RelatedLocalisationPropertiesGutterIconRenderer(
		private val names: Array<String>,
		private val properties: Array<ParadoxLocalisationProperty>,
	) : GutterIconRenderer(), DumbAware {
		private val tooltip = names.joinToString("<br>") { name ->
			message("paradox.script.annotator.relatedLocalisationProperties", name)
		}
		private val title = message("paradox.script.annotator.relatedLocalisationProperties.title")
		
		override fun getIcon() = localisationPropertyGutterIcon
		override fun getTooltipText() = tooltip
		override fun getClickAction() = NavigateAction(title, properties)
		override fun isNavigateAction() = true
		override fun equals(other: Any?) = other is RelatedLocalisationPropertiesGutterIconRenderer && names.contentEquals(other.names)
		override fun hashCode() = names.contentHashCode()
	}
	
	@Suppress("ComponentNotRegistered")
	internal class NavigateAction(
		private val title: String,
		private val elements: Array<out NavigatablePsiElement>,
	) : AnAction() {
		override fun actionPerformed(e: AnActionEvent) {
			//如果只有一个，则直接导航，否则弹出popup再导航
			if(elements.size == 1) {
				OpenSourceUtil.navigate(true, elements.first())
			} else {
				NavigationUtil.getPsiElementPopup(elements, title).show(RelativePoint(e.inputEvent as MouseEvent))
			}
		}
	}
	
	internal class ColorGutterIconRenderer(
		private val color: Color,
	) : GutterIconRenderer(), DumbAware {
		override fun getIcon() = ColorIcon(12, color)
		override fun isNavigateAction() = false
		override fun equals(other: Any?) = other is ColorGutterIconRenderer && color == other.color
		override fun hashCode() = color.hashCode()
	}
	
	private val state = ParadoxSettingsState.getInstance()
	
	override fun annotate(element: PsiElement, holder: AnnotationHolder) {
		when(element) {
			is ParadoxScriptProperty -> annotateProperty(element, holder)
			is ParadoxScriptString -> annotateString(element, holder)
		}
	}
	
	private fun annotateProperty(element: ParadoxScriptProperty, holder: AnnotationHolder) {
		if(!state.resolveInternalReferences) return
		
		val name = element.name
		val project = element.project
		
		//过滤例外情况
		if(element.parent !is ParadoxScriptRootBlock || element.paradoxParentPath.isNullOrEmpty()) return
		if(name.isInvalidPropertyName) return
		
		//注明所有同名的属性
		holder.newSilentAnnotation(INFORMATION)
			.gutterIconRenderer(ScriptPropertyGutterIconRenderer(name, project))
			.create()
		
		//注明所有关联的本地化属性（如果存在）
		val relatedLocalisationProperties = findRelatedLocalisationProperties(name,project).toTypedArray()
		if(relatedLocalisationProperties.isNotEmpty()) {
			val names = relatedLocalisationProperties.mapTo(linkedSetOf()) { it.name }.toTypedArray()
			holder.newSilentAnnotation(INFORMATION)
				.gutterIconRenderer(RelatedLocalisationPropertiesGutterIconRenderer(names, relatedLocalisationProperties))
				.create()
		}
	}
	
	private fun annotateString(element: ParadoxScriptString, holder: AnnotationHolder) {
		if(!state.resolveInternalReferences) return
		
		//过滤非法情况
		val name = element.value
		if(name.isInvalidPropertyName) return
		val project = element.project
		
		//注明所有对应名称的脚本属性，或者本地化属性（如果存在）
		val scriptProperties = findScriptProperties(name, project).toTypedArray()
		if(scriptProperties.isNotEmpty()) {
			holder.newSilentAnnotation(INFORMATION)
				.textAttributes(ParadoxScriptAttributesKeys.SCRIPT_PROPERTY_REFERENCE_KEY)
				.gutterIconRenderer(StringScriptPropertyGutterIconRenderer(name, scriptProperties))
				.create()
			return
		}
		val localisationProperties = findLocalisationProperties(name, project).toTypedArray()
		if(localisationProperties.isNotEmpty()) {
			holder.newSilentAnnotation(INFORMATION)
				.textAttributes(ParadoxScriptAttributesKeys.LOCALISATION_PROPERTY_REFERENCE_KEY)
				.gutterIconRenderer(StringLocalisationPropertyGutterIconRenderer(name, localisationProperties))
				.create()
		}
	}
}
