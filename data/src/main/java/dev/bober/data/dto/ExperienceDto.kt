package dev.bober.data.dto

import dev.bober.domain.model.ExperienceModel
import kotlinx.serialization.Serializable

@Serializable
data class ExperienceDto(
    val previewText : String,
    val text : String,
) {
    fun toModel() : ExperienceModel {
        return ExperienceModel(
            previewText = previewText,
            text = text
        )
    }
}
