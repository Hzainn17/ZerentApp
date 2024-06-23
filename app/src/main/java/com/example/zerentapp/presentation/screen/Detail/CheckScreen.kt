package com.example.zerentapp.presentation.screen.Detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zerentapp.R
import com.example.zerentapp.data.Data
import com.example.zerentapp.model.dCheck
import com.example.zerentapp.model.dPembayaran
import com.example.zerentapp.ui.theme.cardFill1
import com.example.zerentapp.ui.theme.cardFill2
import com.example.zerentapp.ui.theme.cardStroke1
import com.example.zerentapp.ui.theme.cardStroke2
import com.example.zerentapp.ui.theme.mainn

@Composable
fun CheckScreen(navController: NavHostController) {
    val checkList = Data.dataCheck
    val pembayaran = Data.dataPembayaran
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp)) // Add a spacer as a header
        }
        item {
            CheckCard(navController = navController, checkList = checkList, pembayaran = pembayaran)
        }
    }
}

@Composable
fun MyButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(6.dp)
            .size(height = 40.dp, width = 300.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(mainn)
    ) {
        Text(text = "Pesan",
            fontSize = 20.sp)
    }
}

@Composable
private fun CheckCard(
    navController: NavHostController,
    checkList: List<dCheck>,
    pembayaran: List<dPembayaran>,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .padding(15.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = (cardStroke1), shape = RoundedCornerShape(7.dp))
//            .width(400.dp)
//            .height(400.dp)
            ,
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(cardFill1)
//        colors = CardDefaults.cardColors(Color.Blue)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp),
            ) {
                Text( modifier = Modifier
                    ,
                    text = checkList[0].namaToko,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Row (
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    AsyncImage(
                        modifier = Modifier
                            .size(width = 100.dp, height = 90.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = checkList[0].foto)
                            .build(),
                        contentDescription = "Foto Barang"
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(text = checkList[0].nama,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(vertical = 5.dp))
                        Text(text = "Rp.${checkList[0].harga}",fontSize = 17.sp,
                            modifier = Modifier.padding(vertical = 5.dp))
                        Text(text = checkList[0].jumlah,fontSize = 17.sp,
                            modifier = Modifier.padding(vertical = 5.dp))
                    }
                }
                Row (modifier = Modifier
                    .padding(vertical = 7.dp),
                ){
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                    Text(fontSize = 17.sp,text = checkList[0].alamat)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(fontSize = 17.sp,text = "Tanggal Pinjam")
                    Text(fontSize = 17.sp,text = checkList[0].tanggal_pinjam)
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(fontSize = 17.sp,text = "Tanggal Pengembalian")
                    Text(fontSize = 17.sp,text = checkList[0].tanggal_kembali)
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row {
                        Text(fontSize = 17.sp,text = "Total Pesanan")
                        Text(fontSize = 17.sp,text = " (${checkList[0].total} hari)")
                    }
                    Text(fontSize = 17.sp,text = "Rp.${checkList[0].harga}")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Card (modifier = Modifier
            .border(width = 1.dp, color = (cardStroke2), shape = RoundedCornerShape(7.dp)),
            colors = CardDefaults.cardColors(cardFill2),
            )
        {
            Column (modifier = Modifier
                .padding(12.dp)
                ,){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Opsi Pengiriman",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                }
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                    ){
                    Text(text = "Ambil di Tempat")
                    Text(text = "Rp.0")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card (modifier = Modifier
            .border(width = 1.dp, color = (cardStroke2), shape = RoundedCornerShape(7.dp)),
            colors = CardDefaults.cardColors(cardFill2),
        )
        {
            Column (modifier = Modifier
                .padding(12.dp)
                ,){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Opsi Pengiriman",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)

                    Row (
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Image(modifier = Modifier
                            .padding(end = 10.dp)
                            .size(20.dp)
                            ,
                            painter = painterResource(id = R.drawable.img_3), contentDescription = null)
                        Text(text = "DANA",
                            fontWeight = FontWeight.SemiBold)
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Card (modifier = Modifier
            .border(width = 1.dp, color = (cardStroke1), shape = RoundedCornerShape(7.dp)),
            colors = CardDefaults.cardColors(cardFill1),
            elevation = CardDefaults.cardElevation(4.dp),
        )
        {
            Column (modifier = Modifier
                .padding(12.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally
                ){
                Text(
                    text = "Rincian Pembayaran",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                    )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Subtotal Produk",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal)
                    Spacer(modifier = Modifier.width(127.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Rp.")
                        Text(text = pembayaran[0].sub_total,
//                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                            ,
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Deposit",
                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(182.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Rp.")
                        Text(text = pembayaran[0].deposit,
//                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                            ,
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Ongkir",
                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(189.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Rp.")
                        Text(text = pembayaran[0].ongkir,
//                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                            ,
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Biaya Layanan",
                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(137.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Rp.")
                        Text(text = pembayaran[0].layanan,
//                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                            ,
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Total Pembayaran",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(88.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Rp.")
                        Text(text = pembayaran[0].Total,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier,
                            fontSize = 18.sp
                            ,
                        )
                    }
                }

            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyButton(onClick = { navController.navigate("done") })
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun CheckScreenPreview() {
    CheckCard(navController = NavHostController(LocalContext.current), checkList = Data.dataCheck, pembayaran = Data.dataPembayaran)
}