@file:Suppress("UNCHECKED_CAST")

package com.windea.plugin.idea.stellaris.script

import com.intellij.lang.annotation.*
import com.intellij.lang.annotation.HighlightSeverity.*
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.editor.markup.*
import com.intellij.openapi.project.*
import com.intellij.pom.*
import com.intellij.psi.*
import com.intellij.util.*
import com.intellij.util.ui.*
import com.windea.plugin.idea.stellaris.*
import com.windea.plugin.idea.stellaris.StellarisBundle.message
import com.windea.plugin.idea.stellaris.annotations.*
import com.windea.plugin.idea.stellaris.domain.*
import com.windea.plugin.idea.stellaris.localization.psi.*
import com.windea.plugin.idea.stellaris.script.psi.*
import java.awt.*

@ExtensionPoint
class StellarisScriptAnnotator : Annotator ,DumbAware{
	class ScriptPropertyGutterIconRenderer(
		private val name:String,
		private vararg val properties: StellarisScriptProperty
	): GutterIconRenderer(),DumbAware {
		override fun getIcon() = externalScriptPropertyIcon

		override fun getTooltipText() = message("stellaris.script.annotator.externalScriptProperty", name)

		override fun getClickAction() = NavigateAction(*properties)

		override fun isNavigateAction() = true

		override fun equals(other: Any?) = other is ScriptPropertyGutterIconRenderer && name == other.name

		override fun hashCode() = name.hashCode()
	}

	class LocalizationPropertyGutterIconRenderer(
		private val name:String,
		private vararg val properties: StellarisLocalizationProperty
	): GutterIconRenderer(),DumbAware {
		override fun getIcon() = externalLocalizationPropertyIcon

		override fun getTooltipText() = message("stellaris.script.annotator.externalLocalizationProperty", name)

		override fun getClickAction() = NavigateAction(*properties)

		override fun isNavigateAction() = true

		override fun equals(other: Any?) = other is LocalizationPropertyGutterIconRenderer  && name == other.name

		override fun hashCode() = name.hashCode()
	}

	class NavigateAction(
		private vararg val navigatables: Navigatable
	):AnAction(){
		override fun actionPerformed(e: AnActionEvent) {
			OpenSourceUtil.navigate(true,*navigatables)
		}
	}

	class ColorGutterIconRenderer(
		private val color: Color
	):GutterIconRenderer(),DumbAware{
		override fun getIcon() = ColorIcon(12,color)

		override fun isNavigateAction() = false

		override fun equals(other: Any?) = other is ColorGutterIconRenderer && color == other.color

		override fun hashCode() = color.hashCode()
	}

	override fun annotate(element: PsiElement, holder: AnnotationHolder) {
		when(element){
			//字符串可能是script property、localization property
			//只显示gutterIcon，不更改文本颜色
			//本地化属性可以有多个
			is StellarisScriptString -> {
				val name = element.text.unquote()
				val reference = element.reference?:return
				val resolves = reference.multiResolve(false)
				when {
					resolves.isEmpty() -> return
					reference.resolveAsLocalizationProperty -> {
						val properties = resolves.mapArray {it.element as StellarisLocalizationProperty}
						holder.newSilentAnnotation(INFORMATION)
							.gutterIconRenderer(LocalizationPropertyGutterIconRenderer(name,*properties))
							//.textAttributes(StellarisLocalizationAttributesKeys.PROPERTY_KEY_KEY)
							.create()
					}
					else -> {
						val properties = resolves.mapArray {it.element as StellarisScriptProperty}
						holder.newSilentAnnotation(INFORMATION)
							.gutterIconRenderer(ScriptPropertyGutterIconRenderer(name,*properties))
							//.textAttributes(StellarisScriptAttributesKeys.PROPERTY_KEY_KEY)
							.create()
					}
				}
			}
			//对于颜色类型，显示对应的颜色图标
			is StellarisScriptColor -> {
				val color = element.color?:return
				holder.newSilentAnnotation(INFORMATION)
					.gutterIconRenderer(ColorGutterIconRenderer(color))
					.create()
			}
			//NOTE 不能这样做：可能是外部变量，而来源难以判断
			//is StellarisScriptVariableReference -> {
			//	val resolve = element.reference?.resolve()
			//	if(resolve == null) {
			//		holder.newAnnotation(WARNING, message("stellaris.script.annotator.unresolvedVariable"))
			//		.textAttributes(VARIABLE_KEY).create()
			//	}
			//}
		}
	}
}
