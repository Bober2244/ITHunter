package dev.bober.database.entity

import kotlinx.serialization.Serializable

@Serializable
data class SalaryEntity(
    val short : String?,
    val full : String,
)
