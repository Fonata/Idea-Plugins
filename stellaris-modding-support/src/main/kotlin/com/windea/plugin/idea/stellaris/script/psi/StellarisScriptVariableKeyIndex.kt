package com.windea.plugin.idea.stellaris.script.psi

import com.intellij.openapi.project.*
import com.intellij.psi.search.*
import com.intellij.psi.stubs.*

object StellarisScriptVariableKeyIndex: StringStubIndexExtension<StellarisScriptVariable>() {
	private val key = StubIndexKey.createIndexKey<String, StellarisScriptVariable>("stellarisScript.variableIndex")
	
	override fun getKey() = key
	
	override fun get(key: String, project: Project, scope: GlobalSearchScope): List<StellarisScriptVariable> {
		val result =  mutableListOf<StellarisScriptVariable>()
		for(element in StubIndex.getElements(this.key, key, project, scope, StellarisScriptVariable::class.java)) {
			result.add(element)
		}
		return result
	}
	
	
	fun getOne(key: String, project: Project, scope: GlobalSearchScope): StellarisScriptVariable? {
		for(element in StubIndex.getElements(this.key, key, project, scope, StellarisScriptVariable::class.java)) {
			return element
		}
		return null
	}
	
	fun getAll( project: Project, scope: GlobalSearchScope): List<StellarisScriptVariable> {
		val result = mutableListOf<StellarisScriptVariable>()
		for(key in getAllKeys(project)) {
			for(element in get(key, project, scope)) {
				result.add(element)
			}
		}
		return result
	}
	
	inline fun filter(project: Project, scope: GlobalSearchScope, predicate:(String)->Boolean): List<StellarisScriptVariable> {
		val result = mutableListOf<StellarisScriptVariable>()
		for(key in getAllKeys(project)) {
			if(predicate(key)) {
				for(element in get(key, project, scope)) {
					result.add(element)
				}
			}
		}
		return result
	}
}

