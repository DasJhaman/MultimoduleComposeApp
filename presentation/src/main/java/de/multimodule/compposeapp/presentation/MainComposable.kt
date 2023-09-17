package de.multimodule.compposeapp.presentation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users

@Composable
fun MainComposable(userList:List<Users>) {

    LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(userList.size) { index ->
               Text(text = userList[index].userName)
            }
    }

}