package dev.bober.data.dto

data class VacanciesDto(
    val id : String = "",
    val lookingNumber : Int = 0,
    val title : String = "",
    val address : AddressDto? = null,
    val company : String = "",
    val experience : ExperienceDto? = null,
    val publishedDate : String = "",
    val isFavorite : String = "",
    val salary : SalaryDto? = null,
    val schedules : List<String> = emptyList(),
    val appliedNumber : Int = 0,
    val description : String = "",
    val responsibilities : String = "",
    val questions : List<String> = emptyList(),
)
