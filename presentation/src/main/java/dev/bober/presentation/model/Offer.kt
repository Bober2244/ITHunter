package dev.bober.presentation.model

import dev.bober.domain.model.ButtonModel
import dev.bober.presentation.adapter.DelegateItem

data class Offer(
    override val id : String? = null,
    val title : String,
    val button : String?,
    val link : String,
) : DelegateItem
