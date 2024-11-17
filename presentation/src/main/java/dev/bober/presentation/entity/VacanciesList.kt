package dev.bober.presentation.entity

import java.io.Serializable

data class VacanciesList(
    val vacancies: MutableList<Vacancy>
) : Serializable
