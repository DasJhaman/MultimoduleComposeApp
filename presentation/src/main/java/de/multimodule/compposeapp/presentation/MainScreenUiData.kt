package de.multimodule.compposeapp.presentation

import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users

data class MainScreenUiData(val userList: List<Users> = emptyList())
