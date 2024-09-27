package dev.bober.data.dto

import dev.bober.domain.model.VacanciesModel

data class VacanciesDto(
    val id : String,
    val lookingNumber : Int = 0,
    val title : String = "",
    val address : AddressDto? = null,
    val company : String,
    val experience : ExperienceDto? = null,
    val publishedDate : String,
    val isFavorite : String = "",
    val salary : SalaryDto? = null,
    val schedules : List<String> = emptyList(),
    val appliedNumber : Int = 0,
    val description : String = "",
    val responsibilities : String = "",
    val questions : List<String> = emptyList(),
) {
    //TODO: Может вернуть null, надо обработать ошибку
    fun toModel(): VacanciesModel? {
        return address?.let {
            salary?.let { salary ->
                experience?.let { experience ->
                    VacanciesModel(
                        id = id,
                        lookingNumber = lookingNumber,
                        title = title,
                        address = it.toModel(),
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
        }
    }
}
