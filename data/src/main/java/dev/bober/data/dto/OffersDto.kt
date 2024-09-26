package dev.bober.data.dto

data class OffersDto(
    val id : String = "",
    val title : String = "",
    val button : ButtonDto? = null,
    val link : String = "",
)
