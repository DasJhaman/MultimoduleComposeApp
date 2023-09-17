package de.multimodule.compposeapp.data.mapper

import de.multimodule.compposeapp.data.api.dto.UserDto
import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users


fun UserDto.toUser(): Users =
    Users(
        name = name,
        userName = userName,
        email = email
    )

fun List<UserDto>.toUsers() = map { it.toUser() }