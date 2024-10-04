package dev.bober.data.api

import dev.bober.data.dto.ResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("uc")
    suspend fun getData(
        @Query("id") id: String,
        @Query("export") export: String
    ): ResultDto //Result<ResultDto>
}