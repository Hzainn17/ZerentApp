package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.SearchBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BantuanScreen(navController: NavController,
                  modifier: Modifier = Modifier) {

    Scaffold {
        LazyColumn (
            modifier
                .padding(25.dp)
                .fillMaxSize())
        {
            item {

                Row (
                    modifier.fillMaxWidth()
                ){
                    Icon(imageVector = Icons.Default.ArrowBackIos,
                        contentDescription = null,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { navController.navigateUp() }
                        ,
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Bantuan", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(20.dp))

                    SearchBar(
                        //navController = navController,
                        modifier
                            .height(40.dp)
                            .width(400.dp),
                        navController = rememberNavController()
                    )


                Spacer(modifier = Modifier.height(40.dp))

                    Row (modifier = Modifier
                        .padding(8.dp)
                        .height(40.dp)
                        .border(
                            border = BorderStroke(1.dp, Color.Black),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                        ,
                        verticalAlignment = Alignment.CenterVertically,)

                    {

                        Row (
                            modifier = Modifier
                                .padding(start = 10.dp),
                        ){
                            Icon(imageVector = Icons.Default.Person, contentDescription = null)
                        }
                        Row (modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween)
                        {
//                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "Tentang Akun saya")
//                        Spacer(modifier = Modifier.width(153.dp))
                            Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
                        }
                    }


                Spacer(modifier = Modifier.height(25.dp))

                Row (modifier = Modifier
                    .padding(8.dp)
                    .height(40.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,

                ){
                    Row (
                        modifier = Modifier
                            .padding(start = 10.dp),
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_get_cash),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp))
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
//                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Masalah pada pembayaran")
                        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
                    }

                }

                Spacer(modifier = Modifier.height(25.dp))

                Row (modifier = Modifier
                    .padding(8.dp)
                    .height(40.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,

                ){
                    Row (
                        modifier = Modifier
                            .padding(start = 10.dp),
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_services),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp))
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                        Text(text = "Masalah pada aplikasi")
//                        Spacer(modifier = Modifier.width(129.dp))
                        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
                    }
                }


                Spacer(modifier = Modifier.height(25.dp))

                Row (modifier = Modifier
                    .padding(8.dp)
                    .height(40.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Row (
                        modifier = Modifier
                            .padding(start = 10.dp),
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_exchange),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp))

                    }

                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Program saldo kembali")
                        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
                    }

                }

                Spacer(modifier = Modifier.height(25.dp))

                Row (modifier = Modifier
                    .padding(8.dp)
                    .height(40.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,

                ){
                    Row (
                        modifier = Modifier
                            .padding(start = 10.dp),
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_warning_shield),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp))

                    }
                    
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Informasi palsu")
                        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Row (modifier = Modifier
                    .padding(8.dp)
                    .height(40.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,

                ){
                    Row(
                        modifier = Modifier
                            .padding(start = 10.dp),
                    ){
                        Icon(painter = painterResource(id = R.drawable.ic_warning_shield),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp))
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Keamanan dan keadaan darurat")
                        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
                    }
                }


                Spacer(modifier = Modifier.height(50.dp))
                Row (horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)){
                    Row (modifier = Modifier
                        .height(50.dp)
                        .width(130.dp)
                        .border(
                            border = BorderStroke(1.dp, Color.Black),
                            shape = RoundedCornerShape(5.dp)
                        )
                    , verticalAlignment = Alignment.CenterVertically,
                        ){
                        Icon(painter = painterResource(id = R.drawable.ic_information),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp))
                        Spacer(modifier = Modifier
                            .size(8.dp)
                            .padding(start = 5.dp))
                        Text(text = "informasi umum")

                    }
                    Row (modifier = Modifier
                        .height(50.dp)
                        .width(130.dp)
                        .border(
                            border = BorderStroke(1.dp, Color.Black),
                            shape = RoundedCornerShape(5.dp)
                        )
                        , verticalAlignment = Alignment.CenterVertically){
                        Icon(painter = painterResource(id = R.drawable.ic_more),
                            contentDescription = null,
                            modifier = Modifier
                                .size(23.dp)
                                .padding(start = 5.dp))
                        Spacer(modifier = Modifier.size(38.dp))
                        Text(text = "Lainnya")

                    }
                }


                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .width(500.dp)
                        .height(20.dp)
                        .padding(8.dp)
                        .background(Color.Transparent)
                        .drawBehind {
                            val borderSize = 1.dp.toPx()
                            drawLine(
                                color = Color.Black,
                                start = androidx.compose.ui.geometry.Offset(0f, size.height),
                                end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                                strokeWidth = borderSize
                            )
                        }
                ) {

                }


                Row (horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()){
                    Text(text = "Copyright by Ambhilasa pattimura",
                        modifier = Modifier.padding(end = 3.dp),
                        color = Color(0xff043C5B)
                    )
                    Icon(painter = painterResource(id = R.drawable.love),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp))
                }



            }

        }

    }
}




@Preview
@Composable
private fun BantuanScreenPrev() {
    BantuanScreen(navController = rememberNavController())
}