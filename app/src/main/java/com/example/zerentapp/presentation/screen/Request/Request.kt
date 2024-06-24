package com.example.zerentapp.presentation.screen.Request

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zerentapp.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RequestScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: RequestViewModel = hiltViewModel()
) {
    val requests by viewModel.requests.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Request",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B) // Change the color as needed
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                )
        ) {
            LazyColumn {
                items(requests) { request ->
                    RequestCard(request)
                }
            }
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Top
//            ) {
//                RequestCard(
//                    imageUrl = R.drawable.lucas,
//                    user = "Lucas",
//                    time = "2 Day ago",
//                    title = "Skateboard",
//                    category = "Hobi",
//                    startPrice = "50.000",
//                    endPrice = "150.000",
//                    imageProduct = R.drawable.productskateboard,
//                    description = "Need, skateboad... kira-kira untuk pemakaian santai tiap weekend (sabtu-minggu) di sore hari.",
//                )
//                RequestCard(
//                    imageUrl = R.drawable.shinta,
//                    user = "Shinta",
//                    time = "2 Day ago",
//                    title = "Gaun Ball Gown, Putih",
//                    category = "Pakaian",
//                    startPrice = "800.000",
//                    endPrice = "1.500.000",
//                    imageProduct = R.drawable.productgaun,
//                    description = "pengenn pake gaunnn... hadir ke pesta ulang tahun hamdan",
//                )
//            }

            CircularButtonWithIcon(
                navController = navController,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .clickable { navController.navigate("Request2") }
            )
        }
    }
}

@Composable
fun RequestCard(
    request: Request,
//    imageUrl: Int,
//    imageProduct: Int,
//    user: String,
//    time: String,
//    title: String,
//    category: String,
//    startPrice: String,
//    endPrice: String,
//    description: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE2F4FF))
    ) {
        Column(modifier = Modifier
            .padding(10.dp)
            .background(Color(0xffE2F4FF))) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lucas),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = request.userName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                    Text(
                        text = request.waktu,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.width(130.dp))
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options",
                    modifier = Modifier
                        .size(24.dp)
                        .offset(y = (-16).dp, x = (20).dp),
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = request.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.width(250.dp)) {

                    Button(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat button diklik */ },
                        modifier = Modifier
                            .size(width = 50.dp, height = 20.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Cyan
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = request.kategori,
                            fontSize = 12.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Button(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat button diklik */ },
                        modifier = Modifier
                            .size(width = 150.dp, height = 20.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff5AFFA6)
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "Rp${request.priceStart}-Rp${request.priceEnd}",
                            fontSize = 12.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }

                    Text(
                        text = request.deskripsi,
                        fontSize = 14.sp,
                        maxLines = 3,
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.productskateboard),
                    contentDescription = null,
                    modifier = Modifier.size(77.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF043C5B)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.reply_arrow),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Reply",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CircularButtonWithIcon(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    FloatingActionButton(
        onClick = {navController.navigate("Request2")},
        containerColor = Color(0xffFEBD16),
        contentColor = Color.White,
        modifier = modifier.size(56.dp),
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RequestScreenPreview() {
//    RequestScreen(navController = rememberNavController())
//}
