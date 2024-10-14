package dev.bober.domain.usecase

import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.repository.LocalRepository

class SaveDataUseCase(
    private val repository: LocalRepository
) {
    suspend operator fun invoke(offers: List<OfferModel>, vacancies: List<VacancyModel>) {
        repository.insertOffers(offers)
        repository.insertVacancies(vacancies)
    }
}