package dev.bober.data.dto

import dev.bober.domain.model.OfferModel

data class OfferDto(
    val id : String,
    val title : String,
    val button : ButtonDto = ButtonDto(""),
    val link : String,
) {
    fun toModel(): OfferModel {
        return OfferModel(
            id = id,
            title = title,
            button = button.toModel(),
            link = link,
        )
    }
}
