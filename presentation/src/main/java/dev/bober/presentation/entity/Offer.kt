package dev.bober.presentation.entity

import dev.bober.presentation.adapter.DelegateItem

data class Offer(
    override val id : String?,
    val title : String,
    val button : String?,
    val link : String,
) : DelegateItem
