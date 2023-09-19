package de.multimodule.compposeapp.data.repo.features.users

import de.multimodule.compposeapp.data.api.feature_user.UserApi
import de.multimodule.compposeapp.data.mapper.toUsers
import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users
import de.multimodule.compposeapp.domain_layer.features.userlist.features.users.UserRepository
import kotlinx.coroutines.flow.flow

class UserRepositoryImp(private val userApi: UserApi) :
    UserRepository {
    override suspend fun getUserList() = flow<List<Users>>{
        userApi.getUsers().fold(onSuccess = {
            emit(it.toUsers())
        }, onFailure = {
            emit(emptyList())
        })
    }
}
