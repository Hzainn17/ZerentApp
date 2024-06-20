package com.example.zerentapp.presentation.screen.Detail.ToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.navigation.Screen
import kotlinx.coroutines.delay




@Composable
fun PopingButton(navController: NavController, showPopupInitially: Boolean = false) {
//    var showPop by remember { mutableStateOf(false) }
    var showPop by remember { mutableStateOf(showPopupInitially) }
    val garis = Color(android.graphics.Color.parseColor("#323232"))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { showPop = true },
            modifier = Modifier.size(width = 195.dp, height = 50.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF043C5B)),
            shape = RectangleShape
        ) {
            Text(
                text = "Checkout",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }
    }


    if (showPop) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
        )
            AlertDialog(
                modifier = Modifier
//                    .fillMaxSize()
                    .fillMaxWidth()
//                    .size(width = 390.dp, height = 335.dp)
                ,
                shape =  RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 20.dp,
                    bottomEnd = 20.dp,
                    bottomStart = 20.dp,
                    ),
                onDismissRequest = { showPop = false },
                text = {
                    Column (
                        modifier = Modifier,
                    ){

                        Text(
                            modifier = Modifier
                                .padding(vertical = 4.dp),
                            text = "Temoyang, Bulang")
                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))
                        Text(
                            modifier = Modifier
                                .padding(vertical = 4.dp),
                            text = "1")
                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))
                        Text(
                            modifier = Modifier
                                .padding(vertical = 4.dp),
                            text = "11/11/2024 - 12/12/2025")
                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))
                        Text(
                            modifier = Modifier
                                .padding(vertical = 4.dp),
                            text = "Rp.123.000")
                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))
                    }
                },
                confirmButton = {
                    Button(
                        modifier = Modifier
                            .size(width = 130.dp, height = 35.dp)
                        ,

                        shape =  RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp, ),
                        onClick = {
                            showPop = false
                            navController.navigate("check")
                        }
                    ) {
                        Text("Pesan")
                    }
                },
                dismissButton = {
                    OutlinedButton(
                        modifier = Modifier

                            .size(width = 130.dp, height = 35.dp)
                        ,
                        shape =  RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp, ),
                        onClick = { showPop = false
                            navController.navigate(Screen.Whishlist.route)
                        }
                    ) {
                        Text("Wishlist")
                    }
                }
            )
        }
}

//@Preview(showBackground = true)
//@Composable
//fun PopingButtonPreview() {
//    val navController = rememberNavController()
//    PopingButton(navController)
//}

@Preview(showBackground = true)
@Composable
fun PopingButtonWithPopupPreview() {
    val navController = rememberNavController()
    PopingButton(navController, showPopupInitially = true)
}