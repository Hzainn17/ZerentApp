package com.example.zerentapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.zerentapp.model.dBarang
import com.example.zerentapp.presentation.screen.Detail.Detail
import com.example.zerentapp.presentation.screen.Detail.DetailViewModel
import com.example.zerentapp.ui.theme.color1
import com.example.zerentapp.ui.theme.colorBintang
import createImageLoader

@Composable
fun ProductCard(
    navController: NavController,
    product: Detail,
    //dBarang: dBarang,
    viewModel: DetailViewModel = hiltViewModel(),

) {
    val context = LocalContext.current
    val imageLoader = createImageLoader(context)
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(270.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    viewModel.fetchProductsDetail(product.id)
                    navController.navigate("detail/1")
                           },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                verticalArrangement = Arrangement.Top,

                ) {
                Box(
                    modifier = Modifier
                        .height(110.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(context)
                                .data(product.productImage)
                                .size(Size.ORIGINAL)
                                .build(),
                            imageLoader = imageLoader),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize(),
                    )
//                    Image(
//                        painter = painterResource(id = dBarang.foto),
//                        contentDescription = "Foto Produk",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .fillMaxSize(),
//                    )

                    IconButton(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat ikon diklik */ },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp) // Padding untuk memberikan jarak dari tepi
                            .size(24.dp) // Ukuran ikon
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.FavoriteBorder,
                            contentDescription = "Love",
                            tint = Color.White // Warna ikon
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(168.dp)
                    .height(160.dp)
                    .offset(y = (-10).dp), // Offset to move the Card upwards
                //elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = product.productName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp),
                            tint = color1,
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Tanjungpinang",
                            fontSize = 12.sp,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.DarkGray
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Button(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat button diklik */ },
                        modifier = Modifier
                            .size(width = 50.dp, height = 20.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Cyan
                        ),
                        contentPadding = PaddingValues(0.dp) // Atur padding untuk memastikan teks berada di tengah
                    ) {
                        Text(
                            text = "Elektronik",
                            fontSize = 10.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize(), // Mengatur teks agar memenuhi button dan tetap center
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row {
                            repeat(5) {
                                Icon(
                                    Icons.Rounded.StarOutline,
                                    contentDescription = null,
                                    tint = colorBintang,  // Warna untuk bintang kosong
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))
                        Text(
                            text = "Rp${product.productHarga}/hari",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductWhislist(
    dBarang: dBarang
) {
//    val context = LocalContext.current
//    val imageLoader = createImageLoader(context)
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(270.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                verticalArrangement = Arrangement.Top,

                ) {
                Box(
                    modifier = Modifier
                        .height(110.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = dBarang.foto),
                        contentDescription = "Foto Produk",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize(),
                    )

                    IconButton(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat ikon diklik */ },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp) // Padding untuk memberikan jarak dari tepi
                            .size(24.dp) // Ukuran ikon
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Favorite,
                            contentDescription = "Love",
                            tint = Color.Red // Warna ikon
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(168.dp)
                    .height(160.dp)
                    .offset(y = (-10).dp), // Offset to move the Card upwards
                //elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = dBarang.nama,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp),
                            tint = color1,
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = dBarang.lokasi,
                            fontSize = 12.sp,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.DarkGray
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Button(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat button diklik */ },
                        modifier = Modifier
                            .size(width = 50.dp, height = 20.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Cyan
                        ),
                        contentPadding = PaddingValues(0.dp) // Atur padding untuk memastikan teks berada di tengah
                    ) {
                        Text(
                            text = dBarang.category,
                            fontSize = 10.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize(), // Mengatur teks agar memenuhi button dan tetap center
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row {
                            repeat(5) {
                                Icon(
                                    Icons.Rounded.StarOutline,
                                    contentDescription = null,
                                    tint = colorBintang,  // Warna untuk bintang kosong
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))
                        Text(
                            text = "Rp${dBarang.harga}/hari",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding()
                        )
                    }
                }
            }
        }
    }
}


//@Preview (showBackground = true)
//@Composable
//private fun productCardPrev() {
//    ProductCard(navController = NavController(LocalContext.current), dBarang = dBarang(
//        0,
//        "Kamera EOS 3000D",
//        "Hobi",
//        "125000",
//        "Rental cosplay costume mu dengan mudah dan cepat disini.",
//        "Batam",
//        R.drawable.canon3000d
//
//    ))
//}

