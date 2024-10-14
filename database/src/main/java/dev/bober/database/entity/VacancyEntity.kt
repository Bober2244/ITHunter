package dev.bober.database.entity

import androidx.lifecycle.createSavedStateHandle
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.bober.domain.model.AddressModel
import dev.bober.domain.model.ExperienceModel
import dev.bober.domain.model.SalaryModel
import dev.bober.domain.model.VacancyModel

@Entity(tableName = "vacancies")
data class VacancyEntity(
    @PrimaryKey
    val id : String,
    val lookingNumber : Int?,
    val title : String,
    val address : String,
    val company : String,
    val experience : String,
    val publishedDate : String,
    val isFavorite : Boolean,
    val salary : String,
) {
    fun toModel(): VacancyModel{
        return VacancyModel(
            id = id,
            lookingNumber = lookingNumber,
            title = title,
            address = AddressModel(address, "", ""),
            company = company,
            experience = ExperienceModel(experience, experience),
            publishedDate = publishedDate,
            isFavorite = isFavorite,
            salary = SalaryModel(salary, salary),
            schedules = listOf(),
            appliedNumber = null,
            description = null,
            responsibilities = "",
            questions = listOf()
        )
    }
}