package dev.bober.domain.repository

import dev.bober.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ResponseRepository {
    fun getData() : Flow<Resource<Unit>>
}