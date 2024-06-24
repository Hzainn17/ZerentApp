package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.zerentapp.data.Data
import com.example.zerentapp.presentation.component.ProductWhislist

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TokoScreen(navController: NavController,
               modifier: Modifier = Modifier) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  navController.navigate("postingbarang") },
                containerColor = Color(0xFFFEBD16)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Item")
            }
        }
    ) {

        Column(
            modifier
                .fillMaxSize()) {
            Row (
                modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF043C5B))
                    .padding(top = 40.dp, start = 25.dp, end = 25.dp, bottom = 10.dp)){

                Image(
                    painter = painterResource(id = R.drawable.lucas),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "Mj",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        color = Color.White
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

                Spacer(modifier = Modifier.width(138.dp))
                Image(painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp))
            }

            Row (
                modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF043C5B))
                    .padding(start = 25.dp, end = 25.dp)){

                Text(text = "Pengikut : 2002",
                    color = Color.White,
                    fontSize = 12.sp)
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = "Mengikuti : 198",
                    color = Color.White,
                    fontSize = 12.sp)
                Spacer(modifier = Modifier.width(75.dp))
                Text(text = "Rating toko 5",
                    color = Color.White,
                    fontSize = 12.sp)
                Icon(imageVector = Icons.Default.Star,
                    contentDescription = null,
                    Modifier
                        .size(15.dp)
                        .padding(start = 2.dp),
                    tint = Color.White)
            }


            Row (
                modifier
                    .height(110.dp)
                    .fillMaxWidth()
                    .background(Color(0xFFF0F0F0))
                    .padding(start = 25.dp, end = 25.dp)){
                Column (Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ){

                    Text(text = "Tentang Toko",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Menyediakan berbagai keperluan, mulai dari barang Hobi hingga costume anime cosplay. Memberikan pelayanan yang cepat, mudah dan praktis. ",
                        maxLines = 3,
                        fontSize = 11.sp)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row (horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()){

                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.width(350.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF043C5B)
                    ) ,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Update Barang",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp)
                }
            }




            Spacer(modifier = Modifier.height(20.dp))

            Column (Modifier.padding(20.dp)){
                val barangs = remember { Data.dataBarang }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(
                        items = barangs,
                        itemContent = {
                            ProductWhislist(dBarang = it)
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    )
                }
            }




        }





    }
}


@Preview(showBackground = true)
@Composable
private fun TokoScreenPrev() {
    TokoScreen(navController = rememberNavController())
}
