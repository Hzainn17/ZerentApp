package com.example.zerentapp.presentation.screen.Katalog

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zerentapp.data.Data
import com.example.zerentapp.model.dBarang
import com.example.zerentapp.presentation.component.ProductCard
import com.example.zerentapp.presentation.component.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ResultScreen(
    navController: NavController,
    products: List<dBarang> = Data.dataBarang,
    modifier: Modifier = Modifier

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.width(360.dp).clickable {navController.navigate("fail")},
                        contentAlignment = Alignment.Center
                    ) {
                        SearchBar(
                            navController = navController,
                            modifier = Modifier.padding(
                                16.dp
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B) // Change the color as needed
                )
            )
        }
    ) {
        Text(
            text = "Filter Result",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = it.calculateTopPadding() + 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        LazyVerticalGrid(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Adaptive(140.dp),
            modifier = modifier.padding(top = it.calculateTopPadding() + 48.dp)
        ) {
            items(products, key = { it.id }) {
                ProductCard(navController = navController, dBarang = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultScreenPreview() {
        ResultScreen(navController = NavController(LocalContext.current),products = Data.dataBarang)
}