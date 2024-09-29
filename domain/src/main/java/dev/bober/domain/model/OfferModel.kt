package dev.bober.domain.model

data class OfferModel(
    val id : String,
    val title : String,
    val button : ButtonModel,
    val link : String,
)
