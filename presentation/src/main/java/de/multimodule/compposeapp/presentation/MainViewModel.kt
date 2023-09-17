package de.multimodule.compposeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.multimodule.compposeapp.domain_layer.features.userlist.features.users.GetUsersListUseCase
import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val getUsersListUseCase: GetUsersListUseCase) : ViewModel() {

    private val _uiData = MutableStateFlow(MainScreenUiData())
    val uiData = _uiData.asStateFlow()

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            getUsersListUseCase().collect {
                _uiData.update { prev->
                    prev.copy(userList = it)
                }
            }
        }
    }


}