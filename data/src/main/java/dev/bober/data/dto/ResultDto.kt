package dev.bober.data.dto

import dev.bober.domain.model.ResultModel

data class ResultDto(
    val offers: OffersDto,
    val vacancies: VacanciesDto,
) {
    //TODO: Может вернуть null, надо или nullable убрать или все дефолтные значения
    fun toModel() = offers.toModel()?.let { offers ->
        vacancies.toModel()?.let { vacancies ->
            ResultModel(
                offers = offers,
                vacancies = vacancies
            )
        }
    }
}
