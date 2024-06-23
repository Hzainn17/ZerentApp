package com.example.zerentapp.presentation.screen.Request

//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.screen.Detail.DetailViewModel

@Composable
fun Requestform(
    navController: NavController,
    viewModel: RequestViewModel = hiltViewModel(),
){
//    val products by viewModel.products.collectAsState()

        Request2Screen(navController = navController,
            onPostRequest = { request ->
                viewModel.postRequest(request,
                    onSuccess = {
                        "Berhasil"
                    },
                    onError = { error ->
                        "Gagal"
                    }
                )
            } )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Request2Screen(
    navController: NavController,
    modifier: Modifier = Modifier,
    onPostRequest: (Request) -> Unit,
    scrollState: ScrollState = rememberScrollState(),
    viewModel: DetailViewModel = hiltViewModel(),
) {

    val namaBarang = remember { mutableStateOf("") }
    val kategori = remember { mutableStateOf("") }
    val hargaMin = remember { mutableStateOf("") }
    val hargaMax = remember { mutableStateOf("") }
    val deskripsi = remember { mutableStateOf("") }

    val handlePostRequest = {
        val request = Request(
            title = namaBarang.value,
            deskripsi = deskripsi.value,
            kategori = kategori.value,
            priceEnd = hargaMax.value,
            priceStart = hargaMin.value,
            userName = "Hendra",
            waktu = "Today",
            image = "",
        )
        onPostRequest(request)}

    val images: Painter = painterResource(id = R.drawable.imgnotfound)
    // Use WishlistScreen for clarity
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row (
                        modifier = Modifier
                        ,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.White,
                        )
                        Text(
                            text = "Request Barangmu!",
                            modifier = Modifier
                                .padding(start = 15.dp),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
//                    Box(
//                        modifier = Modifier.width(360.dp),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        com.example.zerentapp.presentation.component.SearchBar(
//                            navController = navController,
//                            modifier = Modifier.padding(
//                                16.dp
//                            )
//                        )
//                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B) // Change the color as needed
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding() + 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .verticalScroll(scrollState),
        ) {
            Text(text = "Nama Barang",
                modifier = Modifier
                ,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
                )
            OutlinedTextField(value = namaBarang.value,
                onValueChange = { namaBarang.value = it},
                label = { Text(text = "")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                shape = RoundedCornerShape(10.dp)
                )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Kategori",
                modifier = Modifier
                ,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
                )
            OutlinedTextField(value = kategori.value,
                onValueChange = { kategori.value = it},
                label = { Text(text = "")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                shape = RoundedCornerShape(10.dp)
                )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Kisaran Harga",
                modifier = Modifier
                ,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                ,
                verticalAlignment = Alignment.CenterVertically,
            ){
                OutlinedTextField(value = hargaMin.value,
                    onValueChange = { hargaMin.value = it},
                    label = { Text(text = "Minimum",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.Gray
                    )},
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .weight(1f)
                        .height(60.dp)
                        .padding(end = 8.dp)
                    ,
                    shape = RoundedCornerShape(10.dp)
                )
                Text(
                    text = "-",
                    fontSize = 55.sp,
                    fontWeight = FontWeight.ExtraLight
                )
                OutlinedTextField(value = hargaMax.value,
                    onValueChange = { hargaMax.value = it},
                    label = { Text(text = "Maxmimum",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.Gray
                    )},
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .weight(1f)
                        .height(60.dp)
                        .padding(start = 8.dp)
                    ,
                    shape = RoundedCornerShape(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Deskripsi Singkat",
                modifier = Modifier
                ,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            OutlinedTextField(value = deskripsi.value,
                onValueChange = { deskripsi.value = it},
                label = { Text(text = "")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 6.dp),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .graphicsLayer(
//                        elevation = 4.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = true
                    )
                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(
//                                Color(0xFF043C5B),
//                                Color(0xFF1065A6)
//                            )
//                        )
                        color = Color(0xFFF6F6F6),
                        shape = RoundedCornerShape(16.dp)
                    )
            )
                    {
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxSize()
                                .height(130.dp)
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = "Tambahkan Foto",
                                modifier = Modifier
                                ,
                                fontSize = 17.sp,
                            )

                            Image(
                                painter = images,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(300.dp)
                            )
                        }
                    }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .height(50.dp)
                    .width(500.dp)
//                    .weight(1f)
                    .background(color = Color(0xFF043C5B))
                    .clickable {
                        handlePostRequest()
                        navController.navigate("DoneUp")
                    }
            ) {
                Text(
                    "Kirim", // Text content
                    modifier = Modifier
                        .wrapContentSize() // Adjust size based on content
                        .align(Alignment.Center)
                        .clickable {
                            handlePostRequest()
                            navController.navigate("DoneUp")
                            },
                    color = Color.White,
                    fontSize = 15.sp
                )
            }

        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun Request2ScreenPreview() {
//    Request2Screen(navController = rememberNavController())
//}

