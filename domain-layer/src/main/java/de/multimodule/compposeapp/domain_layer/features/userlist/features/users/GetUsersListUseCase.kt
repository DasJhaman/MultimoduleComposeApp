package de.multimodule.compposeapp.domain_layer.features.userlist.features.users


class GetUsersListUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getUserList()
}