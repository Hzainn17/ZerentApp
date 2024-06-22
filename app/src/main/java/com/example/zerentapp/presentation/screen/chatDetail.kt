package com.example.zerentapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zerentapp.R
import com.example.zerentapp.data.tempData
import com.example.zerentapp.model.ChatList
import com.example.zerentapp.navigation.Screen
import com.example.zerentapp.ui.theme.color1

@Composable
fun chatDetail(

    modifier: Modifier = Modifier,
    navController: NavController,
    chatId: Int?,

    ) {
    val ChatList: List<ChatList> = tempData.chatList.filter { id ->
        id.id == chatId
    }
    ChatCard(ChatList = ChatList)

    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatCard(
    modifier: Modifier = Modifier,
    ChatList: List<ChatList>,) {

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
        ,

        colors = TopAppBarDefaults.topAppBarColors(containerColor = color1),
        title = {
            Row{

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data = ChatList[0].photo)
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 20.dp, horizontal = 10.dp)
                        .clip(CircleShape)
                        .size(35.dp)
                )
            }
            Text(
                modifier = Modifier
                    .padding(start = 50.dp)
                    .padding(top = 22.dp)
                    .padding(horizontal = 15.dp)
                ,
                color = Color.White,
                text = "${ChatList[0].user}",



                )},
        actions = {
            IconButton(onClick = {}) {

                Image(
                    painter = painterResource(id = R.drawable.burgerzen),
                    contentDescription = "mm",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(22.dp)


                )
            }
        },

        )
    Box(modifier = Modifier

        .fillMaxSize()
        .padding(top = 85.dp)
    ) {

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF3E6980),
            modifier = Modifier
                .padding(top = 50.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = "Today",
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier

                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
            )
        }
        Box(modifier = modifier) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                tonalElevation = 4.dp,
                color = Color(0xFF42A7F7),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 100.dp, start = 20.dp)
                    .width(300.dp)
                    .height(60.dp)


            ) {
                Text(
                    text = "This is a pointy chat box.",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier

                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                )
            }

            Text(
                text = "10:00",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )
        }
        Box(modifier = modifier) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                tonalElevation = 4.dp,
                color = Color(0xFF42A7F7),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 200.dp, start = 80.dp)
                    .width(300.dp)
                    .height(60.dp)


            ) {
                Text(
                    text = "p.",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier

                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                )
            }

            Text(
                text = "10:01",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )
        }
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            ChatBottomBar(onSendClick = { message -> /* Send message */ })
        }
    }
}


@Composable
fun ChatBottomBar(
    modifier: Modifier = Modifier,
    onSendClick: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 80.dp, width = 200.dp),
    ) {
        BottomAppBar(
            containerColor = Color(0xFF043C5B),
            contentColor = Color.White,
        ) {
            TextField(
                value = "",
                shape = RoundedCornerShape(20.dp),
                onValueChange = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(top=3.dp, bottom=2.dp, start=10.dp, end=10.dp),
                placeholder = { Text("Type a message") }
            )
            IconButton(onClick = { onSendClick("Your message") }) {
                Icon(imageVector = Icons.Filled.Send, contentDescription = "Send")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CHATScreenPreview(){
    ChatCard(ChatList = tempData.chatList)
}