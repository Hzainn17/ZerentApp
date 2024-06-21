package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.UlasanScreen
import com.example.zerentapp.data.Data
import com.example.zerentapp.model.dBarang
import com.example.zerentapp.model.dUlasan
import com.example.zerentapp.navigation.Screen
import com.example.zerentapp.presentation.screen.Detail.ToolKit.HeaderDetail
import com.example.zerentapp.presentation.screen.Detail.ToolKit.PopingButton


@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavController,
    detailId: Int?

){
    val products by viewModel.products.collectAsState()


    val detailList: List<dBarang> = Data.dataBarang.filter { id ->
        id.id == detailId
    }
    val detail = products.firstOrNull()

    detail?.let {
        DetailCard(navController = navController, detailList = detailList, detail = it)
    } ?: run {
        // Display a loading indicator or error message
        Text(text = "Loading...", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}


@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    onRatingChanged: (Double) -> Unit ,
    starsColor: Color = Color.Black
){
    var halfStar = (rating % 1) != 0.0

    Row {
        for (index in 1..stars) {
            Icon(
                imageVector =
                if (index <= rating) {
                    Icons.Rounded.Star
                } else {
                       if (halfStar) {
                           halfStar = false
                           Icons.Rounded.StarHalf
                       } else {
                           Icons.Rounded.StarOutline
                       }
                       },
                contentDescription = null,
                tint = starsColor,
                modifier = modifier
                    .clickable{ onRatingChanged(index.toDouble()) }
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailCard(
    detail: Detail,
    navController: NavController,
    detailList: List<dBarang>,
    modifier: Modifier = Modifier,
    ulasann: List<dUlasan> = Data.dataUlasan,
    scrollState: ScrollState = rememberScrollState(),
    viewModel: DetailViewModel = hiltViewModel(),) {
    var rating by remember { mutableStateOf(0.0) }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                containerColor = Color(0xFF043C5B)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier.size(width = 195.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RectangleShape
                    ) {
                        Text(
                            text = "Wishlist",
                            color = Color(0xFF043C5B),
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                    }
                    PopingButton(
                        detail,
                        navController = navController,
                        onPostRental = { rental ->
                        viewModel.postRental(rental,
                            onSuccess = {
                                // Handle success
                            },
                            onError = { error ->
                                // Handle error
                            }
                        )
                    } )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row {
                    IconButton(onClick = {navController.navigate(Screen.Home.route)}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = stringResource(id = R.string.menu_back)
                        )
                    }
                    HeaderDetail()
                }
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(width = 400.dp, height = 300.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = detailList[0].foto)
                            .build(),
                        contentDescription = "Foto Barang"
                    )
                }

                //Detail
                Text(
                    text = detail.productName,
                    modifier = Modifier,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Rp"+detail.productHarga,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                Row (
                    modifier = Modifier
                ){
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                    Text( modifier = Modifier, text = detailList[0].lokasi, fontSize = 15.sp)
                }
                Text(
                    modifier = Modifier,
                    text = detail.productDesc,
                    fontSize = 15.sp
                )

            item {
                // Ulasan
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                modifier = Modifier,
                                text = "Penilaian Produk",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RatingBar(
                                modifier = Modifier.padding(5.dp),
                                rating = rating,
                                stars = 5,
                                onRatingChanged = { newRating ->
                                    rating = newRating
                                },
                                starsColor = Color.Yellow
                            )
                            Text(
                                text = "4/5",
                                color = Color.Gray
                            )
                        }

                        LazyRow(
                            contentPadding = PaddingValues(10.dp),
                            modifier = modifier,
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            items(ulasann, key = { it.id }) {
                                UlasanScreen(ulasan = it) {
                                }
                            }
                        }


                    }
                }
            }
        }
        }
    }


@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview(){
    DetailCard(navController = NavController(LocalContext.current), detailList = Data.dataBarang)
}