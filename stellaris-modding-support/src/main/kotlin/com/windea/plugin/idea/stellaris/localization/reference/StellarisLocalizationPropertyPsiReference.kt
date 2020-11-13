@file:Suppress("UNCHECKED_CAST", "UnstableApiUsage", "UnstableApiUsage")

package com.windea.plugin.idea.stellaris.localization.reference

import com.intellij.codeInsight.lookup.*
import com.intellij.openapi.util.*
import com.intellij.psi.*
import com.windea.plugin.idea.stellaris.*
import com.windea.plugin.idea.stellaris.localization.psi.*

class StellarisLocalizationPropertyPsiReference(
	element: StellarisLocalizationPropertyReference,
	rangeInElement: TextRange
) : PsiReferenceBase<StellarisLocalizationPropertyReference>(element, rangeInElement), PsiPolyVariantReference {
	private val name = rangeInElement.substring(element.text)
	private val locale = (element.containingFile as? StellarisLocalizationFile)?.locale?.stellarisLocale

	//只解析相同语言类型的引用

	override fun resolve(): PsiElement? {
		return findLocalizationProperty(name, element.project,locale)
	}

	override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
		return findLocalizationProperties(name, element.project,locale).mapArray {
			PsiElementResolveResult(it)
		}
	}

	//注意要传入elementName而非element
	override fun getVariants(): Array<out Any> {
		return findLocalizationProperties(element.project,locale).mapArray {
			LookupElementBuilder.create(it).withIcon(it.getIcon(0)).withTypeText(it.containingFile.name).withPsiElement(it)
		}
	}
}

