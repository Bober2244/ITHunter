package dev.bober.data.repository

import dev.bober.data.api.Api
import dev.bober.domain.model.ResultModel
import dev.bober.domain.repository.ResponseRepository
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ResponseRepositoryImpl(
    private val api : Api,
    ) : ResponseRepository {
    override suspend fun getData() : Flow<Resource<ResultModel>> = flow {
        emit(Resource.Loading())
        api.getData(ID, EXPORT).fold(
            onSuccess = { emit(Resource.Success(it.toModel())) },
            onFailure = { emit(Resource.Error(it)) }
        )
    }
}

private const val ID = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r"
private const val EXPORT = "download"