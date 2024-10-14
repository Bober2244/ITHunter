package dev.bober.domain.usecase

import dev.bober.domain.repository.LocalRepository

class RemoveFavoriteUseCase(
    private val repository: LocalRepository
) {
    suspend operator fun invoke(id: String) {
        repository.removeFavorite(id)
    }
}