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
        try {
            val response = api.getData(ID, EXPORT)
            emit(Resource.Success(response.toModel()))
        } catch (e : Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
        /*api.getData(ID, EXPORT).fold(
            onSuccess = {
                try {
                    emit(Resource.Success(it.toModel()))
                } catch (e: Exception) {
                    emit(Resource.Error(e))
                    e.printStackTrace()
                }
            },
            onFailure = { emit(Resource.Error(it)) }
        )*/
    }
}

private const val ID = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r"
private const val EXPORT = "download"