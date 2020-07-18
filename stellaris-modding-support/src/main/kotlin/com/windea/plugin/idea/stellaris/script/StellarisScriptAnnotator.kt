package com.windea.plugin.idea.stellaris.script

import com.intellij.lang.annotation.*
import com.intellij.lang.annotation.HighlightSeverity.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.windea.plugin.idea.stellaris.StellarisBundle.message
import com.windea.plugin.idea.stellaris.annotations.*
import com.windea.plugin.idea.stellaris.script.highlighter.StellarisScriptSyntaxHighlighter.Companion.PROPERTY_KEY_KEY
import com.windea.plugin.idea.stellaris.script.highlighter.StellarisScriptSyntaxHighlighter.Companion.VARIABLE_KEY
import com.windea.plugin.idea.stellaris.script.psi.*

@ExtensionPoint
class StellarisScriptAnnotator : Annotator ,DumbAware{
	override fun annotate(element: PsiElement, holder: AnnotationHolder) {
		when(element){
			//is StellarisScriptVariableName -> {
			//	holder.newSilentAnnotation(INFORMATION).textAttributes(VARIABLE_KEY).create()
			//}
			//is StellarisScriptVariableReference -> {
			//	holder.newSilentAnnotation(INFORMATION).textAttributes(VARIABLE_KEY).create()
			//	//NOTE 不能这样做：可能是外部变量，而来源难以判断
			//	val resolve = element.reference?.resolve()
			//	if(resolve == null) {
			//		holder.newAnnotation(WARNING, message("stellaris.script.annotator.unresolvedVariable")).textAttributes(VARIABLE_KEY).create()
			//	}
			//}
			//is StellarisScriptPropertyKey -> {
			//	holder.newSilentAnnotation(INFORMATION).textAttributes(PROPERTY_KEY_KEY).create()
			//}
		}
	}
}
