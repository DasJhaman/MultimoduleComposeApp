package de.multimodule.compposeapp.data.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int,
    val name: String,
    @SerialName("username")
    val userName: String,
    val email: String
)
