package dev.bober.data.dto

import dev.bober.domain.model.OfferModel
import kotlinx.serialization.Serializable

@Serializable
data class OfferDto(
    val id : String? = null,//?
    val title : String,
    val button : ButtonDto? = null,//?
    val link : String,
) {
    fun toModel(): OfferModel {
        return OfferModel(
            id = id,
            title = title,
            button = button?.text,//?.
            link = link,
        )
    }
}
