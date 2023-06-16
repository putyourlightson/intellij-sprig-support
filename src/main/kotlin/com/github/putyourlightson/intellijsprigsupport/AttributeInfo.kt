package com.github.putyourlightson.intellijsprigsupport

@Suppress("MemberVisibilityCanBePrivate")
class AttributeInfo(val attribute: String) {
    private val typeTexts = hashMapOf(
        // https://github.com/putyourlightson/craft-sprig/blob/develop/src/autocompletes/SprigApiAutocomplete.php
        "sprig" to "Makes an element reactive.",
        "s-action" to "Sends an action request to the provided controller action.",
        "s-boost" to "Boosts normal anchors and form tags to use AJAX instead.",
        "s-confirm" to "Shows a `confim()` dialog before issuing a request.",
        "s-disable" to "Disables htmx processing for an element and its children.",
        "s-disinherit" to "Allows you to control attribute inheritance.",
        "s-encoding" to "Allows you to change the request encoding.",
        "s-ext" to "Enables an htmx extension for an element and all its children.",
        "s-headers" to "Allows you to add to the headers that will be submitted with an AJAX request.",
        "s-history" to "Prevents sensitive data being saved to the history cache.",
        "s-history-elt" to "Allows you to specify the element that will be used to snapshot and restore page state during navigation.",
        "s-include" to "Includes additional element values in AJAX requests.",
        "s-indicator" to "The element to put the `htmx-request` class on during the AJAX request.",
        "s-listen" to "Allows you to specify one or more components (as CSS selectors, separated by commas) that when refreshed, should trigger a refresh on the current element.",
        "s-method" to "Forces the request to be of the type provided.",
        "s-on" to "Allows you to respond to events directly on an element.",
        "s-params" to "Filters the parameters that will be submitted with a request.",
        "s-preserve" to "Ensures that an element remains unchanged even when the component is re-rendered.",
        "s-prompt" to "Shows a prompt before submitting a request.",
        "s-push-url" to "Pushes a URL into the URL bar and creates a new history entry.",
        "s-replace" to "Specifies the element to be replaced.",
        "s-replace-url" to "Allows you to replace the current URL of the browser location history.",
        "s-request" to "Allows you to configure various aspects of the request.",
        "s-select" to "Selects a subset of the server response to process.",
        "s-select-oob" to "Selects one or more elements from a server response to swap in via an “Out of Band” swap.",
        "s-swap" to "Controls how the response content is swapped into the DOM.",
        "s-swap-oob" to "Marks content in a response as being “Out of Band”, i.e. swapped somewhere other than the target.",
        "s-sync" to "Allows you to synchronize AJAX requests between multiple elements.",
        "s-target" to "Specifies the target element to be swapped.",
        "s-trigger" to "Specifies the event that triggers the request.",
        "s-val:*" to "Adds a parameter to submit with the request.",
        "s-validate" to "Forces an element to validate itself before it submits a request.",
        "s-vals" to "Adds to the parameters that will be submitted with the request.",
    )

    val name: String = attribute

    val typeText: String

    init {
        typeText = buildTypeText()
    }

    @Suppress("ComplexCondition")
    fun isSprig(): Boolean {
        return this.isAttribute()
    }

    fun isAttribute(): Boolean {
        return AttributeUtil.attributes.contains(name)
    }

    fun hasValue(): Boolean {
        // Prevents the `sprig` attribute from outputting `=""`
        return name != "sprig"
    }

    @Suppress("ReturnCount")
    private fun buildTypeText(): String {
        return typeTexts.getOrDefault(name, "Sprig")
    }
}
