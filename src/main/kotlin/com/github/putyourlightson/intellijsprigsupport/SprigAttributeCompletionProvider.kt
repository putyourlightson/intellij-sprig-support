package com.github.putyourlightson.intellijsprigsupport

import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionUtilCore
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.completion.XmlAttributeInsertHandler
import com.intellij.lang.html.HTMLLanguage
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.html.HtmlTag
import com.intellij.psi.xml.XmlAttribute
import com.intellij.util.ProcessingContext

class SprigAttributeCompletionProvider : CompletionProvider<CompletionParameters?>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val position = parameters.position

        if (HTMLLanguage.INSTANCE !in position.containingFile.viewProvider.languages) {
            return
        }

        val attribute = position.parent as? XmlAttribute ?: return
        val xmlTag = attribute.parent as? HtmlTag ?: return

        val partialAttribute = StringUtil.trimEnd(attribute.name, CompletionUtilCore.DUMMY_IDENTIFIER_TRIMMED)

        if (partialAttribute.isEmpty()) {
            return
        }

        val suggestions = AutoCompleteSuggestions(xmlTag, partialAttribute)

        suggestions.attributes.forEach {
            val text = it.attribute

            var elementBuilder = LookupElementBuilder
                .create(text)
                .withCaseSensitivity(false)
                .withIcon(Sprig.ICON)
                .withTypeText(it.typeText)

            if (it.hasValue()) {
                elementBuilder = elementBuilder.withInsertHandler(XmlAttributeInsertHandler.INSTANCE)
            }

            result.addElement(elementBuilder)
        }
    }
}