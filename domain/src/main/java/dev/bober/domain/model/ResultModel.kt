package dev.bober.domain.model

data class ResultModel(
    val offers : List<OfferModel>,
    val vacancies : List<VacancyModel>,
)
