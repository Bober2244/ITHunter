package dev.bober.presentation.entity

import dev.bober.presentation.adapter.DelegateItem

data class MoreButton private constructor(
    override val id: Any?,
    val text: String,
) : DelegateItem {
    companion object {
        fun create(id: Any, text: String) = MoreButton(id, text)
    }
}
