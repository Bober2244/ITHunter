package dev.bober.presentation.model

import dev.bober.domain.model.ButtonModel
import dev.bober.presentation.adapter.DelegateItem

data class Offer(
    override val id : String,
    val title : String,
    val button : ButtonModel,
    val link : String,
) : DelegateItem
