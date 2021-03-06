package com.windea.plugin.idea.stellaris.localization.refactoring

import com.intellij.patterns.*
import com.intellij.patterns.PlatformPatterns.*
import com.intellij.psi.*
import com.intellij.refactoring.rename.*
import com.intellij.util.*
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationTypes.*

class StellarisLocalizationPropertyRenameInputValidator : RenameInputValidator {
	private val regex = "[a-zA-Z0-9_.\\-']+".toRegex()
	private val pattern = or(psiElement(PROPERTY), psiElement(PROPERTY_REFERENCE))
	
	override fun isInputValid(newName: String, element: PsiElement, context: ProcessingContext): Boolean {
		return regex.matches(newName)
	}

	override fun getPattern(): ElementPattern<out PsiElement> {
		return pattern
	}
}

