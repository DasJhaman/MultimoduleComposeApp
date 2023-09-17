package de.multimodule.compposeapp.domain_layer.features.userlist.features.users

import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun getUserList(): Flow<List<Users>>
}