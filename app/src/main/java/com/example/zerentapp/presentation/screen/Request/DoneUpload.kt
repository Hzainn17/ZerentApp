package com.example.zerentapp.presentation.screen.Request

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun doneUploadScreens(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imagess: Painter = painterResource(id = R.drawable.doneup)
//        Box (
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(180.dp)
//                .graphicsLayer(
////                        elevation = 4.dp,
//                    shape = RoundedCornerShape(16.dp),
//                    clip = true
//                )
//                .background(
////                        Brush.verticalGradient(
////                            colors = listOf(
////                                Color(0xFF043C5B),
////                                Color(0xFF1065A6)
////                            )
////                        )
//                    color = Color(0xFFF6F6F6),
//                    shape = RoundedCornerShape(16.dp)
//                )
//        )

//            Column (
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxSize()
////                    .height(130.dp)
//                    .padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ){
        Column (
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Image(
                painter = imagess,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
            )
            Text(text = "Barang Berhasil di Upload",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 10.dp),
                fontWeight = FontWeight.Normal
                )
        }


        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .height(50.dp)
                .width(500.dp)
//                    .weight(1f)
                .background(color = Color(0xFF043C5B))
                .clickable { navController.navigate("Request") }
        ) {
            Text(
                "Menu", // Text content
                modifier = Modifier
                    .wrapContentSize() // Adjust size based on content
                    .align(Alignment.Center)
                    .clickable { navController.navigate("Request")},
                color = Color.White,
                fontSize = 15.sp
            )
        }

    }
    }



@Preview(showBackground = true)
@Composable
fun Request2ScreensPreview() {
    doneUploadScreens(navController = rememberNavController())
}

