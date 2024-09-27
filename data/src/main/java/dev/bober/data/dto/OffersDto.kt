package dev.bober.data.dto

import dev.bober.domain.model.OffersModel

data class OffersDto(
    val id : String = "",
    val title : String = "",
    val button : ButtonDto? = null,
    val link : String = "",
) {
    //TODO: Может вернуть null, надо обработать ошибку
    fun toModel(): OffersModel? {
        return button?.let {
            OffersModel(
                id = id,
                title = title,
                button = it.toModel(),
                link = link,
            )
        }
    }
}
