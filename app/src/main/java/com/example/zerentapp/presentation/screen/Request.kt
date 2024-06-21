package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
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
fun RequestScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
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
        // Main content with background image and padding
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                RequestCard(
                    imageUrl = R.drawable.lucas,
                    user = "Lucas",
                    time = "2 Day ago",
                    title = "Skateboard",
                    category = "Hobi",
                    startPrice = "50.000",
                    endPrice = "150.000",
                    imageProduct = R.drawable.productskateboard,
                    description = "Need, skateboad... kira-kira untuk pemakaian santai tiap weekend (sabtu-minggu) di sore hari.",
                )
                RequestCard(
                    imageUrl = R.drawable.shinta,
                    user = "Shinta",
                    time = "2 Day ago",
                    title = "Gaun Ball Gown, Putih",
                    category = "Pakaian",
                    startPrice = "800.000",
                    endPrice = "1.500.000",
                    imageProduct = R.drawable.productgaun,
                    description = "pengenn pake gaunnn... hadir ke pesta ulang tahun hamdan",
                )
            }

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
    imageUrl: Int,
    imageProduct: Int,
    user: String,
    time: String,
    title: String,
    category: String,
    startPrice: String,
    endPrice: String,
    description: String,
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
                    painter = painterResource(id = imageUrl),
                    contentDescription = "$user image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = user,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                    Text(
                        text = "$time",
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
                text = title,
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
                            text = "$category",
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
                            text = "Rp$startPrice-Rp$endPrice",
                            fontSize = 12.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }

                    Text(
                        text = description,
                        fontSize = 14.sp,
                        maxLines = 3,
                    )
                }

                Image(
                    painter = painterResource(id = imageProduct),
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

@Preview(showBackground = true)
@Composable
fun RequestScreenPreview() {
    RequestScreen(navController = rememberNavController())
}
