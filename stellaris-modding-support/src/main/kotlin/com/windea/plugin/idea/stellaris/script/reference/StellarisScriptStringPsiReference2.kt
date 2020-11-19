package com.windea.plugin.idea.stellaris.script.reference

import com.intellij.openapi.util.*
import com.intellij.psi.*
import com.windea.plugin.idea.stellaris.*
import com.windea.plugin.idea.stellaris.localization.psi.*
import com.windea.plugin.idea.stellaris.script.psi.*
import com.windea.plugin.idea.stellaris.settings.*

class StellarisScriptStringPsiReference2(
	element: StellarisScriptString,
	rangeInElement: TextRange
) : PsiReferenceBase<StellarisScriptString>(element, rangeInElement), PsiPolyVariantReference {
	//去除包围的引号
	private val name = element.text.unquote()
	
	var resolveAsLocalizationProperty = true
	
	override fun resolve(): StellarisLocalizationProperty? {
		if(StellarisSettingsState.getInstance().resolveInternalReferences) {
			return findLocalizationProperty(name, element.project, inferedStellarisLocale)
		}
		return null
	}
	
	override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
		if(StellarisSettingsState.getInstance().resolveInternalReferences) {
			return findLocalizationProperties(name, element.project).mapArray {
				PsiElementResolveResult(it)
			}
		}
		return ResolveResult.EMPTY_ARRAY
	}
}