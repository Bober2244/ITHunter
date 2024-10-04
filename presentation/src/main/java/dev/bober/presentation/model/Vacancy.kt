package dev.bober.presentation.model

import dev.bober.domain.model.AddressModel
import dev.bober.domain.model.ExperienceModel
import dev.bober.domain.model.SalaryModel
import dev.bober.presentation.adapter.DelegateItem

data class Vacancy(
    override val id : String,
    val lookingNumber : Int?,
    val title : String,
    val address : AddressModel,
    val company : String,
    val experience : ExperienceModel,
    val publishedDate : String,
    val isFavorite : Boolean,
    val salary : SalaryModel,
    val schedules : List<String>,
    val appliedNumber : Int,
    val description : String,
    val responsibilities : String,
    val questions : List<String>,
) : DelegateItem
