package dev.bober.data.repository

import dev.bober.data.Api
import dev.bober.data.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ResponseRepositoryImpl(
    val api : Api,
    ) {
    suspend fun getData() : Flow<Resource<Unit>> = flow {

    }
}