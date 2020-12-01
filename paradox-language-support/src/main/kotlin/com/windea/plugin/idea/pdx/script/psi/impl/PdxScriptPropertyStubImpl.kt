package com.windea.plugin.idea.pdx.script.psi.impl

import com.intellij.psi.stubs.*
import com.windea.plugin.idea.pdx.script.psi.*

class PdxScriptPropertyStubImpl(
	parent: StubElement<*>,
	override val key: String
) : StubBase<PdxScriptProperty>(parent, PdxScriptStubElementTypes.PROPERTY), PdxScriptPropertyStub
