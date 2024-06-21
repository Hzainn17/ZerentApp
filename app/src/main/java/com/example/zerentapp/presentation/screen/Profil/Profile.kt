package com.example.zerentapp.presentation.screen.Profil

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Your title content */ },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B) // Change the color as needed
                )
            )
        }
    ) {
        Column(Modifier.fillMaxSize()) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp)
                    .height(80.dp)
                    .background(Color(0xFF043C5B))
            ) {
                // Your Row content goes here
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-80).dp),
            ) {
                Card(
                    modifier = Modifier
                        .padding(top = 0.dp, start = 20.dp, end = 20.dp)
                        .clip(shape = RoundedCornerShape(18.dp))  // Clip to the same shape as the border
                        .border(
                            width = 2.dp,
                            color = Color(0xFFDBE5EB),
                            shape = RoundedCornerShape(18.dp)
                        )
                        .fillMaxSize(),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White) // Change the color as needed
                ) {
                    Column(Modifier.padding(top = 50.dp, start = 30.dp, bottom = 30.dp, end = 30.dp)) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.lucas),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Column {
                                Text(
                                    text = "Mj",
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Button(
                                    onClick = { /* Tambahkan aksi yang ingin dilakukan saat button diklik */ },
                                    modifier = Modifier
                                        .size(width = 100.dp, height = 20.dp),
                                    shape = CircleShape,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xffFEBD16)
                                    ),
                                    contentPadding = PaddingValues(0.dp) // Atur padding untuk memastikan teks berada di tengah
                                ) {
                                    Text(
                                        text = "Anak Sultan",
                                        fontSize = 12.sp,
                                        color = Color.Black,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.fillMaxSize(), // Mengatur teks agar memenuhi button dan tetap center
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(100.dp))

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("profilesetting") }) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_profile_setting),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(text = "Pengaturan Profile" , fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(70.dp))
                                Icon(
                                    imageVector = Icons.Default.ArrowForwardIos,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            // Adding a bottom border
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color.Gray)
                                    .align(Alignment.BottomCenter)
                            )
                        }






                        Box(modifier = Modifier.fillMaxWidth()
                            .clickable { navController.navigate("toko") }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_store_setting),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(text = "Pengaturan Toko" , fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(82.dp))
                                Icon(
                                    imageVector = Icons.Default.ArrowForwardIos,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            // Adding a bottom border
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color.Gray)
                                    .align(Alignment.BottomCenter)
                            )
                        }








                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("bantuan") }) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_help),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(text = "Bantuan" , fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(151.dp))
                                Icon(
                                    imageVector = Icons.Default.ArrowForwardIos,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            // Adding a bottom border
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color.Gray)
                                    .align(Alignment.BottomCenter)
                            )
                        }




                    }


                    
                }



            }




        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileSettingPrev() {
    ProfileScreen(navController = rememberNavController())
}
