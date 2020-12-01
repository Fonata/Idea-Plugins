package com.windea.plugin.idea.pdx.localisation.intentions

import com.intellij.codeInsight.intention.*
import com.intellij.openapi.command.WriteCommandAction.*
import com.intellij.openapi.editor.*
import com.intellij.openapi.project.*
import com.intellij.openapi.ui.popup.*
import com.intellij.openapi.ui.popup.util.*
import com.intellij.psi.*
import com.windea.plugin.idea.pdx.*
import com.windea.plugin.idea.pdx.localisation.psi.*

class ChangeSerialNumberIntention : IntentionAction {
	companion object{
		val instance = ChangeSerialNumberIntention()
	}

	override fun startInWriteAction() = false

	override fun getText() = message("pdx.localisation.intention.changeSerialNumber")

	override fun getFamilyName() = text

	override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
		if(editor == null || file == null) return false
		val element = file.findElementAt(editor.caretModel.offset)?.parent as? PdxLocalisationSerialNumber
		return element != null
	}

	override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
		if(editor == null || file == null) return
		val element = file.findElementAt(editor.caretModel.offset)?.parent as? PdxLocalisationSerialNumber ?: return
		val values = localisationSerialNumberCache.register(project)
		JBPopupFactory.getInstance().createListPopup(Popup(element, values)).showInBestPositionFor(editor)
	}

	private class Popup(
		private val value: PdxLocalisationSerialNumber,
		values: Array<PdxLocalisationSerialNumber>
	) : BaseListPopupStep<PdxLocalisationSerialNumber>(message("pdx.localisation.intention.changeSerialNumber.title"), *values){
		override fun getTextFor(value: PdxLocalisationSerialNumber) = value.pdxSerialNumber!!.popupText

		override fun getDefaultOptionIndex() = 0

		override fun isSpeedSearchEnabled(): Boolean = true

		override fun onChosen(selectedValue: PdxLocalisationSerialNumber?, finalChoice: Boolean): PopupStep<*>? {
			if(selectedValue!= null) {
				//需要在WriteCommandAction里面执行
				runWriteCommandAction(selectedValue.project) { value.setName(selectedValue.name!!) }
			}
			return PopupStep.FINAL_CHOICE
		}
	}
}