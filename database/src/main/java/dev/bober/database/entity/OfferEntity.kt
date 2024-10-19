package dev.bober.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.bober.domain.model.OfferModel

@Entity(tableName = "offers")
data class OfferEntity(
    val id : String?,
    @PrimaryKey
    val title : String,
    val button : String?,
    val link : String,
)