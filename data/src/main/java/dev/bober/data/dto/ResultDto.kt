package dev.bober.data.dto

import dev.bober.domain.model.ResultModel

data class ResultDto(
    val offers: List<OfferDto>,
    val vacancies: List<VacanciesDto>,
) {
    fun toModel(): ResultModel {
        return ResultModel(
            offers = offers.map { it.toModel() },
            vacancies = vacancies.map { it.toModel() }
        )
    }
}
