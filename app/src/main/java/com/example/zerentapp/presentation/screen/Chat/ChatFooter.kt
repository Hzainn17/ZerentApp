package com.example.zerentapp.presentation.Chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zerentapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatFooter(navController: NavController.Companion) {

   Row(  modifier = Modifier
       .padding(16.dp)
       .padding(top = 700.dp, start = 30.dp),
       horizontalArrangement = Arrangement.spacedBy(25.dp)) {
       Text(
           text = "Copyright by Ambhilasa Pattimura",
           textAlign = TextAlign.Start,
           fontWeight = FontWeight.Bold,
           color = Color(0xFF043C5B),
           overflow = TextOverflow.Ellipsis,



       )
       Image(
           painter = painterResource(id = R.drawable.lopelope),
           contentDescription = "Chat",
           modifier = Modifier
               .size(22.dp)


       )

   }


}





@Preview(showBackground = true)
@Composable
private fun ChatSettingPrev() {
    ChatFooter(navController = NavController)
}