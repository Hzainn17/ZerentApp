package com.example.zerentapp.presentation.screen.Order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.zerentapp.R
import com.example.zerentapp.data.Data
import com.example.zerentapp.model.dBarang
import com.example.zerentapp.presentation.component.ProductCard
import org.w3c.dom.Text


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Log(
    navController: NavController,
    modifier: Modifier = Modifier,
    barangs: List<dBarang> = Data.dataBarang,
) {
    var text by remember { mutableStateOf("") }
  TopAppBar(
      title = { Text(text = "Konfirmasi Barang Sampai")
              TextButton(
                  modifier = modifier
                      .padding(start = 310.dp,)
                      .padding(vertical = 5.dp)
                  ,

                  onClick = { /*TODO*/ }) {
                  Text(
                      modifier = modifier
                          .offset(y = -10.dp)
                        ,
                      text = " Kirim")
              }
      })
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 100.dp)
        ,
    ) {
     Column(modifier = Modifier
         .border(
             2.dp,
             Color.Black,
             RoundedCornerShape(5.dp)
         )
         .size(height = 150.dp, width = 380.dp)
         ,
         ) {
         Text(

             text = "03/05/2024",
             modifier = Modifier
                 .padding(start = 150.dp)
                 .offset(y = 10.dp, x = 120.dp)
         )
         Text(

             text = "Kamera EOS 3000D",
             modifier = Modifier
                 .padding(start = 150.dp)
                 .offset(y = 30.dp)
         )
         Text(

             text = "Diterima",
             modifier = Modifier
                 .padding(start = 150.dp)
                 .offset(y = 30.dp)
         )
         Image(
         painter = painterResource(id = R.drawable.canon3000d),
         contentDescription = "Example Image from Local File",
         modifier = Modifier
             .height(100.dp)
             .offset( y = -25.dp, x = 15.dp)
          ,
         contentScale = ContentScale.Crop
     )

         Spacer(modifier = Modifier.height(8.dp))

     }
     }

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 280.dp)
        ,
    ) {
        Column(modifier = Modifier
            .border(
                2.dp,
                Color.Black,
                RoundedCornerShape(5.dp)
            )
            .size(height = 100.dp, width = 380.dp)
            ,
        ) {
            Image(
                painter = painterResource(id = R.drawable.fotofog),
                contentDescription = "Example Image from Local File",
                modifier = Modifier
                    .height(50.dp)
                    .width(40.dp)
                    .padding(top = 10.dp)
                    .offset(x = 35.dp, y = 15.dp)
                ,


                contentScale = ContentScale.Crop
            )
            Text(

                text = "Tambahkan Gambar",
                modifier = Modifier
                    .padding(start = 150.dp)
                    .offset(y = -15.dp)
                )
            Spacer(modifier = Modifier.height(8.dp))

        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 410.dp)
        ,
    ) {
        Column(modifier = Modifier
            ,
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Beri Kami Alasan Nya") },
                modifier = Modifier
                    .offset(y = 15.dp)
                    .border(
                        2.dp,
                        Color.Black,
                        RoundedCornerShape(5.dp)
                    )
                    .size(height = 300.dp, width = 380.dp),
                shape =RoundedCornerShape(
                    topEnd = 5.dp,
                    topStart = 5.dp,
                    bottomEnd = 5.dp,
                    bottomStart = 5.dp, ),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent,
                    errorBorderColor = Color.Transparent
                )

            )
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
    }

@Preview(showBackground = true)
@Composable
private fun Logprev() {
    Log(navController = rememberNavController())
}
