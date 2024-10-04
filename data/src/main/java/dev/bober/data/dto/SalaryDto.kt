package dev.bober.data.dto

import dev.bober.domain.model.SalaryModel
import kotlinx.serialization.Serializable

@Serializable
data class SalaryDto(
    val short : String? = null,//?
    val full : String
) {
    fun toModel() : SalaryModel {
        return SalaryModel(
            short = short,
            full = full
        )
    }
}
