package com.windea.plugin.idea.paradox.localisation.intentions

import com.intellij.codeInsight.intention.*
import com.intellij.openapi.command.WriteCommandAction.*
import com.intellij.openapi.editor.*
import com.intellij.openapi.project.*
import com.intellij.openapi.ui.popup.*
import com.intellij.openapi.ui.popup.util.*
import com.intellij.psi.*
import com.windea.plugin.idea.paradox.*
import com.windea.plugin.idea.paradox.localisation.psi.*

object ChangeSerialNumberIntention : IntentionAction {
	override fun startInWriteAction() = false
	
	override fun getText() = message("paradox.localisation.intention.changeSerialNumber")
	
	override fun getFamilyName() = text
	
	override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
		if(editor == null || file == null) return false
		val element = file.findElementAt(editor.caretModel.offset)?.parent
		return element is ParadoxLocalisationSerialNumber
	}
	
	override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
		if(editor == null || file == null) return
		val element = file.findElementAt(editor.caretModel.offset)?.parent
		if(element is ParadoxLocalisationSerialNumber) {
			JBPopupFactory.getInstance().createListPopup(Popup(element, ParadoxSerialNumber.values)).showInBestPositionFor(editor)
		}
	}
	
	private class Popup(
		private val value: ParadoxLocalisationSerialNumber,
		values: Array<ParadoxSerialNumber>
	) : BaseListPopupStep<ParadoxSerialNumber>(message("paradox.localisation.intention.changeSerialNumber.title"), *values) {
		override fun getTextFor(value: ParadoxSerialNumber) = value.popupText
		
		override fun getDefaultOptionIndex() = 0
		
		override fun isSpeedSearchEnabled(): Boolean = true
		
		override fun onChosen(selectedValue: ParadoxSerialNumber, finalChoice: Boolean): PopupStep<*>? {
			//需要在WriteCommandAction里面执行
			runWriteCommandAction(value.project) { value.setName(selectedValue.name) }
			return PopupStep.FINAL_CHOICE
		}
	}
}
