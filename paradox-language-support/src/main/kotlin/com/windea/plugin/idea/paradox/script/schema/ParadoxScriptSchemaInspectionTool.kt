package com.windea.plugin.idea.paradox.script.schema

import com.intellij.codeInspection.*
import com.intellij.codeInspection.ui.*
import com.intellij.psi.*
import com.jetbrains.jsonSchema.ide.*
import com.jetbrains.jsonSchema.impl.*
import com.windea.plugin.idea.paradox.message
import com.windea.plugin.idea.paradox.script.psi.*
import javax.swing.*

//org.jetbrains.yaml.schema.YamlJsonSchemaInspectionBase
//org.jetbrains.yaml.schema.YamlJsonSchemaHighlightingInspection

class ParadoxScriptSchemaInspectionTool : LocalInspectionTool() {
	private val walker = ParadoxScriptJsonLikePsiWalker

	@JvmField public var caseInsensitiveEnum = true

	override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean, session: LocalInspectionToolSession): PsiElementVisitor {
		val file = holder.file
		if(file is ParadoxScriptFile) {
			val roots = walker.getRoots(file)
			if(roots.isNotEmpty()) {
				val service = JsonSchemaService.Impl.get(file.project)
				val virtualFile = file.viewProvider.virtualFile
				if(service.isApplicableToFile(virtualFile)) {
					val rootSchema = service.getSchemaObject(file)
					if(rootSchema != null) {
						return doBuildVisitor(holder, session, roots, rootSchema)
					}
				}
			}
		}
		return PsiElementVisitor.EMPTY_VISITOR
	}

	private fun doBuildVisitor(holder: ProblemsHolder, session: LocalInspectionToolSession, roots: Collection<PsiElement>, schemaObject: JsonSchemaObject): PsiElementVisitor {
		val options = JsonComplianceCheckerOptions(caseInsensitiveEnum)
		return object : ParadoxScriptVisitor() {
			override fun visitElement(element: PsiElement) {
				if(element in roots) {
					JsonSchemaComplianceChecker(schemaObject, holder, walker, session, options, "Schema validation: ").annotate(element)
				}
				super.visitElement(element)
			}
		}
	}

	override fun createOptionsPanel(): JComponent? {
		val optionsPanel = MultipleCheckboxOptionsPanel(this)
		optionsPanel.addCheckbox(message("paradox.script.inspection.schemaValidation.caseInsensitiveEnum"), "caseInsensitiveEnum")
		return optionsPanel
	}
}
