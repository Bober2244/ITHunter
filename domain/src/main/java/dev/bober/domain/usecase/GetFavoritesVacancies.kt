package dev.bober.domain.usecase

import dev.bober.domain.model.VacancyModel
import dev.bober.domain.repository.LocalRepository
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFavoritesVacancies(
    private val repository: LocalRepository
) {
    suspend operator fun invoke (): Flow<Resource<List<VacancyModel>>> {
        return repository.getFavorites().map {
            when (it) {
                is Resource.Loading -> Resource.Loading()
                is Resource.Success -> Resource.Success(it.data)
                is Resource.Error -> Resource.Error(it.error)
            }
        }

    }
}