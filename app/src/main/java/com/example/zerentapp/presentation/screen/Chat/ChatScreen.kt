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
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.ChatlistItem
import com.example.zerentapp.data.tempData
import com.example.zerentapp.model.ChatList
import com.example.zerentapp.navigation.Screen
import com.example.zerentapp.ui.theme.color1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    chatlists: List<ChatList> = tempData.chatList,
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

        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Adaptive(100.dp),
            horizontalItemSpacing = 4.dp,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier.fillMaxSize()
        ) {
            items(chatlists, key = { it.id }) {
                ChatlistItem(
                    onItemClicked = { chatId ->
                        navController.navigate(Screen.chatDetail.route + "/$chatId")
                    }, ChatList = it)

            }
        }




        Spacer(modifier = Modifier.height(8.dp))

    }
    ChatFooter(navController = NavController)

}

