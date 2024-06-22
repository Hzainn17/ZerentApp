package com.example.zerentapp.presentation.Chat






import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.ChatlistItem
import com.example.zerentapp.data.tempData
import com.example.zerentapp.model.ChatList
import com.example.zerentapp.ui.theme.color1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    chatlists: List<ChatList> = tempData.chatList,
    navController: NavController,
    ChatList: List<ChatList>,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(25.dp),modifier = Modifier.
    fillMaxSize()){

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)
            ,

            colors = TopAppBarDefaults.topAppBarColors(containerColor = color1),
            title = {
                Row{

                    IconButton(
                        modifier = Modifier
                            .padding(vertical = 14.dp),
                        onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            tint = Color.White,
                            contentDescription = stringResource(
                                id = R.string.arrow_keluar
                            )
                        )
                    }
                }
                Text(
                    modifier = Modifier
                .padding(start = 50.dp)
                .padding(top = 22.dp),
                    color = Color.White,
                    text = "Chat",



                )},
                 actions = {

            },

        )
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 90.dp)

        ,
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.align(Alignment.Center)
        ) {
            items(chatlists, key = { it.id }) {
                ChatlistItem(ChatList = it)

            }
        }

        Spacer(modifier = Modifier.height(8.dp))

    }
    ChatFooter(navController = NavController)

}

@Preview(showBackground = true)
@Composable
private fun ChatPrev() {
    ChatScreen(navController = NavController(LocalContext.current), ChatList = tempData.chatList)
}