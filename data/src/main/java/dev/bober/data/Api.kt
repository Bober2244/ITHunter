package dev.bober.data

import dev.bober.data.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET
    suspend fun getData(
        @Query("id")
        id: String,
        @Query("export")
        export: String
    ): ResultDto
}