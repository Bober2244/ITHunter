package dev.bober.domain.usecase

import dev.bober.domain.model.ResultModel
import dev.bober.domain.repository.ResponseRepository
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetDataUseCase(
    private val repository: ResponseRepository
) {
    suspend operator fun invoke(): Flow<Resource<ResultModel>> {
        return repository.getData().map { res ->
            when(res) {
                is Resource.Loading -> Resource.Loading()
                is Resource.Error -> Resource.Error(res.error)
                is Resource.Success -> Resource.Success(res.data)
            }
        }
    }
}