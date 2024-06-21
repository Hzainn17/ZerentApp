package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.SearchBar
import com.example.zerentapp.ui.theme.color1
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.Navigation
import com.example.zerentapp.data.Data
import com.example.zerentapp.presentation.component.ProductCard
import com.example.zerentapp.ui.theme.poppinsFontFamily
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Card (
                        shape = CircleShape,
                        modifier = Modifier
                            .size(40.dp)
                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.profil),
                        contentDescription = null,
                        Modifier
                            .wrapContentSize(),
                        contentScale = ContentScale.Crop
                    )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Selamat Datang, MJ!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                SearchBar(
                    navController = navController,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                bannerSliding()

                // Banner promo
//                LazyRow(modifier = Modifier.fillMaxWidth()) {
//                    items(3) {
//                        Card(
//                            modifier
//                                .height(120.dp)
//                                .width(353.dp)
//                                .fillMaxWidth()
//                                .padding(end = 5.dp)
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.bannerpromohome),
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .fillMaxSize(1f),
//                                contentScale = ContentScale.FillWidth
//                            )
//                        }
//                    }
//                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clickable { navController.navigate("Kategori")}
                    ,
                ) {
                    Text(
                        text = "Kategori",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "More",
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.W500,
                        color = color1,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(top = 3.dp)
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(top = 3.dp),
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                // Kategori
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.padding(bottom = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(topStart = 18.dp))
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                                .clickable { navController.navigate("Kategori")}
                        ) {
                            Text(
                                "Hobi", // Text content
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(topEnd = 18.dp))
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                                .clickable { navController.navigate("Kategori")}
                        ) {
                            Text(
                                "Kendaraan",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                    }

                    Row(modifier = Modifier.padding(top = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(bottomStart = 18.dp))
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                                .clickable { navController.navigate("Kategori")}
                        ) {
                            Text(
                                "Pakaian",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(bottomEnd = 18.dp))
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                                .clickable { navController.navigate("Kategori")}
                        ) {
                            Text(
                                "Peralatan",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Terbaru",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Card terbaru
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val barangs = remember { Data.dataBarang }
                    LazyRow(
                    ) {
                        items(
                            items = barangs,
                            itemContent = {
                                ProductCard(navController = navController, dBarang = it)
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Paling Banyak Disewa",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                // Card Paling laris
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val barangs = remember { Data.dataBarangBanyakDisewa }
                    LazyRow(
                    ) {
                        items(
                            items = barangs,
                            itemContent = {
                                ProductCard(navController = navController, dBarang = it)
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        )
                    }
                }
                Spacer(modifier = modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun bannerSliding(

) {
    val listState = rememberLazyListState()
    val items = listOf(
        R.drawable.bannerpromohome,
        R.drawable.bannerpromohome2,
        R.drawable.bannerpromohome3
    )

    LaunchedEffect(Unit) {
        var currentIndex = 0
        while (true) {
            delay(2000)
            currentIndex = (currentIndex + 1) % items.size
            listState.animateScrollToItem(
                index = currentIndex,
            )
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items) { item ->
            Card (
                modifier = Modifier
                    .height(120.dp)
                    .width(353.dp)
                    .padding(end = 5.dp)
            ){
                Image(
                    painter = painterResource(id = item),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun homeprev() {
    HomeScreen(navController = rememberNavController())
}
