package de.multimodule.compposeapp.data.api.feature_user

import de.multimodule.compposeapp.data.api.dto.UserDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserApi(private val ktorClient: HttpClient) {
    suspend fun getUsers(): Result<List<UserDto>> = runCatching {
        ktorClient.get("users") {
        }.body()
    }
}