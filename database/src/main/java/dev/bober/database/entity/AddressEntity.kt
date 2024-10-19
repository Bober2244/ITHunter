package dev.bober.database.entity

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
data class AddressEntity(
    val town: String,
    val street: String,
    val house : String,
)