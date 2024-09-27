package dev.bober.domain.repository

import dev.bober.domain.model.ResultModel
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ResponseRepository {
    suspend fun getData() : Flow<Resource<ResultModel>>
}