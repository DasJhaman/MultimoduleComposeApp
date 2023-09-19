package de.multimodule.compposeapp.presentation.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.multimodule.compposeapp.domain_layer.features.userlist.models.Users

@Composable
fun MainComposable(userList: List<Users>, onUserClick: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        items(userList.size) { index ->
            SingleUserItem(user = userList[index], onUserClick = onUserClick)
        }
    }
}

@Composable
fun SingleUserItem(user: Users,onUserClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onUserClick(user.id) }
            .padding(8.dp)
    ) {
        Text(text = user.userName, fontSize = 18.sp)
        Text(text = user.email, fontSize = 14.sp)
    }
}