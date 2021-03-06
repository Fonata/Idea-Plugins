@file:Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")

package com.windea.plugin.idea.paradox.localisation.psi.impl

import com.intellij.openapi.util.Iconable.*
import com.intellij.psi.*
import com.intellij.refactoring.suggested.*
import com.windea.plugin.idea.paradox.*
import com.windea.plugin.idea.paradox.localisation.psi.*
import com.windea.plugin.idea.paradox.localisation.psi.ParadoxLocalisationElementFactory.createColorfulText
import com.windea.plugin.idea.paradox.localisation.psi.ParadoxLocalisationElementFactory.createIcon
import com.windea.plugin.idea.paradox.localisation.psi.ParadoxLocalisationElementFactory.createLocale
import com.windea.plugin.idea.paradox.localisation.psi.ParadoxLocalisationElementFactory.createPropertyKey
import com.windea.plugin.idea.paradox.localisation.psi.ParadoxLocalisationElementFactory.createPropertyReference
import com.windea.plugin.idea.paradox.localisation.psi.ParadoxLocalisationElementFactory.createSerialNumber
import com.windea.plugin.idea.paradox.localisation.reference.*
import javax.swing.*

//NOTE getName 确定进行重构和导航时显示的PsiElement的名字
//NOTE setName 确定进行重命名时的逻辑
//NOTE getNameIdentifier ？
//NOTE getTextOffset 确定选中一个PsiElement时，哪一部分会高亮显示
//NOTE getReference 确定选中一个PsiElement时，哪些其他的PsiElement会同时高亮显示

object ParadoxLocalisationPsiImplUtil {
	//region ParadoxLocalisationLocale
	@JvmStatic
	fun getName(element: ParadoxLocalisationLocale): String? {
		return element.localeId.text
	}
	
	@JvmStatic
	fun setName(element: ParadoxLocalisationLocale, name: String): PsiElement {
		element.localeId.replace(createLocale(element.project, name).localeId)
		return element
	}
	
	@JvmStatic
	fun getNameIdentifier(element: ParadoxLocalisationLocale): PsiElement {
		return element.localeId
	}
	
	@JvmStatic
	fun getIcon(element: ParadoxLocalisationLocale, @IconFlags flags: Int): Icon {
		return paradoxLocalisationLocaleIcon
	}
	
	@JvmStatic
	fun getParadoxLocale(element: ParadoxLocalisationLocale): ParadoxLocale? {
		return ParadoxLocale.map[element.name]
	}
	//endregion
	
	//region ParadoxLocalisationProperty
	@JvmStatic
	fun getName(element: ParadoxLocalisationProperty): String {
		return element.stub?.key?: element.propertyKey.text
	}
	
	@JvmStatic
	fun setName(element: ParadoxLocalisationProperty, name: String): PsiElement {
		element.propertyKey.replace(createPropertyKey(element.project, name))
		return element
	}
	
	@JvmStatic
	fun getNameIdentifier(element: ParadoxLocalisationProperty): PsiElement {
		return element.propertyKey.propertyKeyId
	}
	
	@JvmStatic
	fun getIcon(element: ParadoxLocalisationProperty, @IconFlags flags: Int): Icon {
		return paradoxLocalisationPropertyIcon
	}
	
	@JvmStatic
	fun getValue(element: ParadoxLocalisationProperty): String? {
		return element.propertyValue?.text?.unquote()
	}
	
	@JvmStatic
	fun getParadoxLocale(element: ParadoxLocalisationProperty): ParadoxLocale? {
		return (element.containingFile as? ParadoxLocalisationFile)?.paradoxLocale
	}
	//endregion
	
	//region ParadoxLocalisationPropertyReference
	@JvmStatic
	fun getName(element: ParadoxLocalisationPropertyReference): String? {
		return element.propertyReferenceId?.text
	}
	
	@JvmStatic
	fun setName(element: ParadoxLocalisationPropertyReference, name: String): PsiElement {
		element.propertyReferenceId?.replace(createPropertyReference(element.project, name).propertyReferenceId!!)
		return element
	}
	
	@JvmStatic
	fun getNameIdentifier(element: ParadoxLocalisationPropertyReference): PsiElement? {
		return element.propertyReferenceId
	}
	
	@JvmStatic
	fun getTextOffset(element: ParadoxLocalisationPropertyReference): Int {
		return element.startOffset + 1
	}
	
	@JvmStatic
	fun getReference(element: ParadoxLocalisationPropertyReference): ParadoxLocalisationPropertyPsiReference? {
		return element.propertyReferenceId?.let { ParadoxLocalisationPropertyPsiReference(element, it.textRangeInParent) }
	}
	
	@JvmStatic
	fun getParadoxColor(element: ParadoxLocalisationPropertyReference): ParadoxColor? {
		val colorCode = element.propertyReferenceParameter?.text?.firstOrNull()
		if(colorCode != null && colorCode.isUpperCase()) {
			return ParadoxColor.map[colorCode.toString()]
		}
		return null
	}
	//endregion
	
	//region ParadoxLocalisationIcon
	@JvmStatic
	fun getName(element: ParadoxLocalisationIcon): String? {
		return element.iconId?.text
	}
	
	@JvmStatic
	fun setName(element: ParadoxLocalisationIcon, name: String): PsiElement {
		element.iconId?.replace(createIcon(element.project, name).iconId!!)
		return element
	}
	
	@JvmStatic
	fun getNameIdentifier(element: ParadoxLocalisationIcon): PsiElement? {
		return element.iconId
	}
	
	@JvmStatic
	fun getTextOffset(element: ParadoxLocalisationIcon): Int {
		return element.startOffset + 1
	}
	//endregion
	
	//region ParadoxLocalisationSerialNumber
	@JvmStatic
	fun getName(element: ParadoxLocalisationSerialNumber): String? {
		return element.serialNumberId?.text?.toUpperCase()
	}
	
	@JvmStatic
	fun setName(element: ParadoxLocalisationSerialNumber, name: String): PsiElement {
		element.serialNumberId?.replace(createSerialNumber(element.project, name).serialNumberId!!)
		return element
	}
	
	@JvmStatic
	fun getNameIdentifier(element: ParadoxLocalisationSerialNumber): PsiElement? {
		return element.serialNumberId
	}
	
	@JvmStatic
	fun getTextOffset(element: ParadoxLocalisationSerialNumber): Int {
		return element.startOffset + 1
	}
	
	@JvmStatic
	fun getParadoxSerialNumber(element: ParadoxLocalisationSerialNumber): ParadoxSerialNumber? {
		val name = element.name ?: return null
		return ParadoxSerialNumber.map[name]
	}
	//endregion
	
	//region ParadoxLocalisationColorfulText
	@JvmStatic
	fun getName(element: ParadoxLocalisationColorfulText): String? {
		return element.colorCode?.text?.toUpperCase()
	}
	
	@JvmStatic
	fun setName(element: ParadoxLocalisationColorfulText, name: String): PsiElement {
		element.colorCode?.replace(createColorfulText(element.project, name).colorCode!!)
		return element
	}
	
	@JvmStatic
	fun getNameIdentifier(element: ParadoxLocalisationColorfulText): PsiElement? {
		return element.colorCode
	}
	
	@JvmStatic
	fun getTextOffset(element: ParadoxLocalisationColorfulText): Int {
		return element.startOffset + 1
	}
	
	@JvmStatic
	fun getParadoxColor(element: ParadoxLocalisationColorfulText): ParadoxColor? {
		return element.name?.let { name -> ParadoxColor.map[name] }
	}
	//endregion
}
