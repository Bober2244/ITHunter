package dev.bober.database.entity

import androidx.room.Entity

@Entity(tableName = "vacancies")
data class VacancyEntity(
    val id : String,
    val lookingNumber : Int?,
    val title : String,
    val address : String,
    val company : String,
    val experience : String,
    val publishedDate : String,
    val isFavorite : Boolean,
    val salary : String,
)