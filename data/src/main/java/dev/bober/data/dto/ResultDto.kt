package dev.bober.data.dto

import dev.bober.domain.model.ResultModel

data class ResultDto(
    val offers: OffersDto,
    val vacancies: VacanciesDto,
) {
    fun toModel() = offers.toModel()?.let { offers ->
        vacancies.toModel()?.let { vacancies ->
            ResultModel(
                offers = offers,
                vacancies = vacancies
            )
        }
    }
}
