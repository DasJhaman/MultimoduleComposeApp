package de.multimodule.compposeapp.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import de.multimodule.compposeapp.presentation.theme.CompposeMultimoduleAppTheme
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompposeMultimoduleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent(mainViewModel: MainViewModel = getViewModel()) {
    val uiState = mainViewModel.uiData.collectAsState()
    CompposeMultimoduleAppTheme {
        MainComposable(
            userList = uiState.value.userList,
            onUserClick = { }) // TODO: Navigate to User detail screen here by using nav host
    }
}