package dev.bober.database.entity

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
data class ExperienceEntity(
    val previewText : String,
    val text : String,
)
