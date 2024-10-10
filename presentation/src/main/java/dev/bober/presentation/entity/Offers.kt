package dev.bober.presentation.entity

import dev.bober.presentation.adapter.DelegateItem

data class Offers(
    override val id: MutableList<Offer>
) : DelegateItem
