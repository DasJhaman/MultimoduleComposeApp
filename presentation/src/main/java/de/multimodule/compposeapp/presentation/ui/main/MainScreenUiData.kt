package de.multimodule.compposeapp.presentation.ui.main

import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users

data class MainScreenUiData(val userList: List<Users> = emptyList())
