package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.data.Data
import com.example.zerentapp.presentation.component.ProductWhislist
import com.example.zerentapp.presentation.component.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun KategoriScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.width(360.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        com.example.zerentapp.presentation.component.SearchBar(
                            navController = navController,
                            modifier = Modifier.padding(
                                16.dp
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B)
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
                    bottom = 16.dp
                )
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {

                // Kategori
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.padding(bottom = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topStart = 18.dp,
                                        topEnd = 18.dp,
                                        bottomEnd = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Hobi",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.Yellow
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topEnd = 18.dp,
                                        topStart = 18.dp,
                                        bottomStart = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Kendaraan",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.padding(top = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topStart = 18.dp,
                                        topEnd = 18.dp,
                                        bottomEnd = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Elektronik",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topEnd = 18.dp,
                                        topStart = 18.dp,
                                        bottomStart = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Peralatan",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.padding(top = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topStart = 18.dp,
                                        topEnd = 18.dp,
                                        bottomEnd = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Kendaraan",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topEnd = 18.dp,
                                        topStart = 18.dp,
                                        bottomStart = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Pakaian",
                                modifier = Modifier
                                    .wrapContentSize() 
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
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
fun KategoriScreenPreview() {
    KategoriScreen(navController = rememberNavController())
}

