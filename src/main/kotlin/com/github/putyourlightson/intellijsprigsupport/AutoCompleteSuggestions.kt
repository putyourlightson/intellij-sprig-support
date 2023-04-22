package com.github.putyourlightson.intellijsprigsupport

class AutoCompleteSuggestions {

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
