package dev.bober.data.dto

import dev.bober.domain.model.ButtonModel

data class ButtonDto(
    val text : String
) {
    fun toModel() : ButtonModel {
        return ButtonModel(
            text = text
        )
    }
}
