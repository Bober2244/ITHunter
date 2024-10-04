package dev.bober.data.dto

import dev.bober.domain.model.AddressModel
import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    val town : String,
    val street : String,
    val house : String,
) {
    fun toModel() : AddressModel {
        return AddressModel(
            town = town,
            street = street,
            house = house,
        )
    }
}
