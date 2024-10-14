package dev.bober.domain.usecase

import dev.bober.domain.model.VacancyModel
import dev.bober.domain.repository.LocalRepository

class AddFavoriteUseCase(
    private val repository: LocalRepository
) {
    suspend operator fun invoke(vacancy: VacancyModel) {
        repository.addFavorite(vacancy)
    }
}