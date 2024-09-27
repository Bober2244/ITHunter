package dev.bober.data.dto

import dev.bober.domain.model.ResultModel

data class ResultDto(
    val offers: OffersDto,
    val vacancies: VacanciesDto,
) {
    fun toModel() = ResultModel(
        offers.toModel(),
        vacancies.toModel()
    )
}
