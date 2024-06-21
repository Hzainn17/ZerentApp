package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
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
fun ProfileSetting(navController: NavController,
                   modifier: Modifier = Modifier) {

    Scaffold {
        LazyColumn (
            modifier
                .padding(25.dp)
                .fillMaxSize()){

            item{
                Row (
                    modifier = Modifier,
//                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(imageVector = Icons.Default.ArrowBackIos,
                        contentDescription = null,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { navController.navigateUp() }
                        ,
                    )

                    Text(text = "Informasi Pribadi", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(40.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(id = R.drawable.lucas),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(60.dp))

                    Text(text = "Lengkapi Foto" , fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(60.dp))
                
                Text(text = "Nama Lengkap")
                var nama by remember {
                    mutableStateOf("")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = nama, // Set the initial value
                    onValueChange = { nama = it }, // Update state on change
                    modifier = modifier
                        .border( // Black border with rounded corners
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(400.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp), // Add horizontal padding
                    colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
                        containerColor = Color.Transparent, // Make background transparent
                        focusedIndicatorColor = Color.Transparent, // Remove selection highlight
                        unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Jenis Kelamin")
                var JK by remember {
                    mutableStateOf("")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = JK, // Set the initial value
                    onValueChange = { JK = it }, // Update state on change
                    modifier = modifier
                        .border( // Black border with rounded corners
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(400.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp), // Add horizontal padding
                    colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
                        containerColor = Color.Transparent, // Make background transparent
                        focusedIndicatorColor = Color.Transparent, // Remove selection highlight
                        unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
                    )
                )



                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Tanggal Lahir")
                var TL by remember {
                    mutableStateOf("")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = TL, // Set the initial value
                    onValueChange = { TL = it }, // Update state on change
                    modifier = modifier
                        .border( // Black border with rounded corners
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(400.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp), // Add horizontal padding
                    colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
                        containerColor = Color.Transparent, // Make background transparent
                        focusedIndicatorColor = Color.Transparent, // Remove selection highlight
                        unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
                    )
                )



                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Pekerjaan")
                var pekerjaan by remember {
                    mutableStateOf("")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = pekerjaan, // Set the initial value
                    onValueChange = { pekerjaan = it }, // Update state on change
                    modifier = modifier
                        .border( // Black border with rounded corners
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(400.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp), // Add horizontal padding
                    colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
                        containerColor = Color.Transparent, // Make background transparent
                        focusedIndicatorColor = Color.Transparent, // Remove selection highlight
                        unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
                    )
                )



                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Nama Instansi")
                var NI by remember {
                    mutableStateOf("")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = NI, // Set the initial value
                    onValueChange = { NI = it }, // Update state on change
                    modifier = modifier
                        .border( // Black border with rounded corners
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(400.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp), // Add horizontal padding
                    colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
                        containerColor = Color.Transparent, // Make background transparent
                        focusedIndicatorColor = Color.Transparent, // Remove selection highlight
                        unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
                    )
                )



                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Kota Asal")
                var KA by remember {
                    mutableStateOf("")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = KA, // Set the initial value
                    onValueChange = { KA = it }, // Update state on change
                    modifier = modifier
                        .border( // Black border with rounded corners
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(400.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp), // Add horizontal padding
                    colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
                        containerColor = Color.Transparent, // Make background transparent
                        focusedIndicatorColor = Color.Transparent, // Remove selection highlight
                        unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
                    )
                )


                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Kontak Darurat")
                var KD by remember {
                    mutableStateOf("")
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = KD, // Set the initial value
                    onValueChange = { KD = it }, // Update state on change
                    modifier = modifier
                        .border( // Black border with rounded corners
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(400.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp), // Add horizontal padding
                    colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
                        containerColor = Color.Transparent, // Make background transparent
                        focusedIndicatorColor = Color.Transparent, // Remove selection highlight
                        unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
                    )
                )


                Spacer(modifier = Modifier.height(12.dp))
                Row (horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()){

                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.width(300.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF043C5B)
                        ),
                        shape = RoundedCornerShape(10.dp)) {
                        Text(text = "SIMPAN")
                    }
                }




            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ProfileSettingPrev() {
    ProfileSetting(navController = rememberNavController())
}