package dev.bober.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancies")
data class VacancyEntity(
    @PrimaryKey
    val id : String,
    val lookingNumber : Int? = null,
    val title : String = "",
    val address : AddressEntity = AddressEntity("", "", ""),
    val company : String = "",
    val experience : ExperienceEntity = ExperienceEntity("", ""),
    val publishedDate : String = "",
    val isFavorite : Boolean = false,
    val salary : SalaryEntity = SalaryEntity("", ""),
    val schedules : List<String> = emptyList(),
    val appliedNumber : Int? = null,
    val description : String? = null,
    val responsibilities : String = "",
    val questions : List<String> = emptyList(),
)