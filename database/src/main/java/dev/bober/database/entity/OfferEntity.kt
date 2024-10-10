package dev.bober.database.entity

import androidx.room.Entity

@Entity(tableName = "offers")
data class OfferEntity(
    val id : String,
    val title : String,
    val button : String?,
    val link : String,
)