package dev.bober.domain.model

data class VacancyModel(
    val id : String,
    val lookingNumber : Int,
    val title : String,
    val address : AddressModel,
    val company : String,
    val experience : ExperienceModel,
    val publishedDate : String,
    val isFavorite : String,
    val salary : SalaryModel,
    val schedules : List<String>,
    val appliedNumber : Int,
    val description : String,
    val responsibilities : String,
    val questions : List<String>,
)
