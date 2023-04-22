package com.github.putyourlightson.intellijsprigsupport

import com.github.putyourlightson.intellijsprigsupport.completion.SprigSwapCompletion
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.XmlPatterns
import com.intellij.psi.xml.XmlTokenType

class SprigCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns
                .psiElement(XmlTokenType.XML_NAME)
                .withParent(XmlPatterns.xmlAttribute()),
            SprigAttributeCompletionProvider()
        )
        extend(
            CompletionType.BASIC,
            PlatformPatterns
                .psiElement(XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN)
                .inside(XmlPatterns.xmlAttribute("s-swap")),
            SprigSwapCompletion()
        )
    }
}