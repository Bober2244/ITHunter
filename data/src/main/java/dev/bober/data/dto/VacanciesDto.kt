package dev.bober.data.dto

import dev.bober.domain.model.VacancyModel

data class VacanciesDto(
    val id : String,
    val lookingNumber : Int = 0,
    val title : String,
    val address : AddressDto,
    val company : String,
    val experience : ExperienceDto,
    val publishedDate : String,
    val isFavorite : Boolean,
    val salary : SalaryDto,
    val schedules : List<String>,
    val appliedNumber : Int = 0,
    val description : String = "",
    val responsibilities : String,
    val questions : List<String>,
) {
    fun toModel(): VacancyModel {
        return VacancyModel(
            id = id,
            lookingNumber = lookingNumber,
            title = title,
            address = address.toModel(),
            company = company,
            experience = experience.toModel(),
            publishedDate = publishedDate,
            isFavorite = isFavorite,
            salary = salary.toModel(),
            schedules = schedules,
            appliedNumber = appliedNumber,
            description = description,
            responsibilities = responsibilities,
            questions = questions,
        )
    }
}
