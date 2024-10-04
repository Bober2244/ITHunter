package dev.bober.data.dto

import dev.bober.domain.model.ButtonModel
import kotlinx.serialization.Serializable

@Serializable
data class ButtonDto(
    val text : String
) {
    fun toModel() : ButtonModel {
        return ButtonModel(
            text = text
        )
    }
}
