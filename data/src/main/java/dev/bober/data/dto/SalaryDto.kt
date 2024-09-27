package dev.bober.data.dto

import dev.bober.domain.model.SalaryModel

data class SalaryDto(
    val short : String = "",
    val full : String = ""
) {
    fun toModel() : SalaryModel {
        return SalaryModel(
            short = short,
            full = full
        )
    }
}
