package com.example.zerentapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.zerentapp.model.ChatList
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.zerentapp.R


@Composable
fun ChatlistItem(
    ChatList: ChatList,
    modifier: Modifier = Modifier,

    //onItemClicked: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp)

    ) {
        Spacer(modifier = Modifier
            .width(10.dp))
        Image(
            painter = painterResource(id = ChatList.photo),
            contentDescription = ChatList.user,
            //modifier = Modifier.fillMaxWidth()
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(start = 10.dp)
        ) {
            Text(
                text = ChatList.user,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = ChatList.textchat,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
//                color = when ("Masakan.tingkat") {
//                    "Eazy" -> Color.Green
//                    "Try Hard" -> Color(0xFFFC6A03)
//                    "Chef Kampus" -> Color.Red
//                    else -> Color.Black
//                }
            )
        }
    }
    Divider(
        color = Color.LightGray,
        thickness = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
    )
}


@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ChatlistItem(
        ChatList = ChatList(
            1,
            "Kumii",
            "sender",
            "fixx yaaa?",
            R.drawable.ku
        ),
    )
}
