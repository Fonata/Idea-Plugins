package com.windea.plugin.idea.stellaris.localization.highlighter

import com.intellij.openapi.editor.colors.*
import com.intellij.openapi.fileTypes.*
import com.intellij.psi.StringEscapesTokenTypes.*
import com.intellij.psi.TokenType.*
import com.intellij.psi.tree.*
import com.windea.plugin.idea.stellaris.annotations.*
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationTypes.*

@ExtensionPoint
class StellarisLocalizationSyntaxHighlighter : SyntaxHighlighterBase() {
	companion object {
		private val COLON_KEYS = arrayOf(StellarisLocalizationAttributesKeys.COLON_KEY)
		private val NUMBER_KEYS = arrayOf(StellarisLocalizationAttributesKeys.NUMBER_KEY)
		private val PROPERTY_HEADER_KEYS = arrayOf(StellarisLocalizationAttributesKeys.PROPERTY_HEADER_KEY)
		private val PROPERTY_KEY_KEYS = arrayOf(StellarisLocalizationAttributesKeys.PROPERTY_KEY_KEY)
		private val PROPERTY_VALUE_KEYS = arrayOf(StellarisLocalizationAttributesKeys.PROPERTY_VALUE_KEY)
		private val COMMENT_KEYS = arrayOf(StellarisLocalizationAttributesKeys.COMMENT_KEY)
		private val MARKER_KEYS = arrayOf(StellarisLocalizationAttributesKeys.MARKER_KEY)
		private val CODE_KEYS = arrayOf(StellarisLocalizationAttributesKeys.CODE_KEY)
		private val ICON_KEYS = arrayOf(StellarisLocalizationAttributesKeys.ICON_KEY)
		private val SERIAL_NUMBER_CODE_KEYS = arrayOf(StellarisLocalizationAttributesKeys.SERIAL_NUMBER_CODE_KEY)
		private val COLOR_CODE_KEYS = arrayOf(StellarisLocalizationAttributesKeys.COLOR_CODE_KEY)
		private val VALID_ESCAPE_KEYS = arrayOf(StellarisLocalizationAttributesKeys.VALID_ESCAPE_KEY)
		private val INVALID_ESCAPE_KEYS = arrayOf(StellarisLocalizationAttributesKeys.INVALID_ESCAPE_KEY)
		private val BAD_CHARACTER_KEYS = arrayOf(StellarisLocalizationAttributesKeys.BAD_CHARACTER_KEY)
		private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
	}

	override fun getTokenHighlights(tokenType: IElementType?) = when(tokenType) {
		HEADER_TOKEN -> PROPERTY_HEADER_KEYS
		KEY_TOKEN -> PROPERTY_KEY_KEYS
		VALUE_TOKEN, LEFT_QUOTE, RIGHT_QUOTE -> PROPERTY_VALUE_KEYS
		PROPERTY_REFERENCE_START, PROPERTY_REFERENCE_END, CODE_START, CODE_END, ICON_START, ICON_END,
		SERIAL_NUMBER_START, SERIAL_NUMBER_END, COLORFUL_TEXT_START, COLORFUL_TEXT_END -> MARKER_KEYS
		NUMBER -> NUMBER_KEYS
		CODE_TEXT -> CODE_KEYS
		ICON_TEXT -> ICON_KEYS
		SERIAL_NUMBER_CODE -> SERIAL_NUMBER_CODE_KEYS
		COLORFUL_TEXT_CODE -> COLOR_CODE_KEYS
		COMMENT, ROOT_COMMENT -> COMMENT_KEYS
		VALID_STRING_ESCAPE_TOKEN -> VALID_ESCAPE_KEYS
		INVALID_CHARACTER_ESCAPE_TOKEN, INVALID_UNICODE_ESCAPE_TOKEN -> INVALID_ESCAPE_KEYS
		BAD_CHARACTER -> BAD_CHARACTER_KEYS
		else -> EMPTY_KEYS
	}

	override fun getHighlightingLexer() = StellarisLocalizationHighlighterLexer()
}


