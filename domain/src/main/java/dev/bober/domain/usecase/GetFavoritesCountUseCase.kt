package dev.bober.domain.usecase

import dev.bober.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow

class GetFavoritesCountUseCase(
    private val repository: LocalRepository
) {
    suspend operator fun invoke(): Flow<Int> {
        return repository.getFavoritesCount()
    }
}