package com.github.putyourlightson.intellijsprigsupport

import com.intellij.psi.html.HtmlTag

class AutoCompleteSuggestions(val htmlTag: HtmlTag, val partialAttribute: String) {

    val attributes: MutableList<AttributeInfo> = mutableListOf()

    init {
        addAttributes()
    }

    private fun addAttributes() {
        for (attribute in AttributeUtil.attributes) {
            attributes.add(AttributeInfo(attribute))
        }
    }
}
