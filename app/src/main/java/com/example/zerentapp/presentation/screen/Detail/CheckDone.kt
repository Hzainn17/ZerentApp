package com.example.zerentapp.presentation.screen.Detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zerentapp.R
import com.example.zerentapp.data.Data
import com.example.zerentapp.model.dPembayaran
import com.example.zerentapp.ui.theme.cardFill1
import com.example.zerentapp.ui.theme.cardStroke1
import com.example.zerentapp.ui.theme.mainn


@Composable
fun MyButton2(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(6.dp)
            .size(height = 40.dp, width = 300.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(mainn)
    ) {
        Text(text = "Kembali",
            fontSize = 20.sp)
    }
}

@Composable
fun Check(navController: NavController,){
    val pembayaran = Data.dataPembayaran
    CheckDone( pembayaran = pembayaran)
}
@Composable
fun CheckDone(

    modifier: Modifier = Modifier,
    pembayaran: List<dPembayaran>,
    //checkList: List<dCheck>
){
    Box(
        modifier = Modifier
            .fillMaxHeight(0.5f)
        ,
    ) {
        Image(painter = painterResource(id = R.drawable.img_4)
            , contentDescription = null ,
            modifier = Modifier
                .fillMaxSize()
            ,
            contentScale = ContentScale.FillBounds
            )
    }

    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Card (
            modifier = Modifier
                .padding(top = 20.dp)
//                .size(30.dp)
                .scale(1.5f)
                .drawWithContent {
                    drawContent()
                    drawCircle(
                        color = (Color(0XFF026D9E)),
                        radius = size.minDimension / 2,
                        center = Offset(size.width / 2, size.height / 2),
                        style = Stroke(width = 2.dp.toPx())
                    )
                }
            ,

        ){
            Icon(imageVector = Icons.Default.Check, contentDescription = null)
        }
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier
            ,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            text = "Transaksi Berhasil"
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier
            ,
            color = Color.White,
            text = "07 Mei 2024, 00:15:37 WIB")

        Card (modifier = Modifier
            .padding(25.dp)
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "No. Transaksi",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(127.dp))
                        Text(text = "SP78292BW001",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                            ,
                        )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Tanggal Mulai",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal)
                    Spacer(modifier = Modifier.width(127.dp))
                    Text(text = "08/05/2024",
//                            fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                        ,
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Tanggal Berakhir",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal)
                    Spacer(modifier = Modifier.width(127.dp))
                    Text(text = "10/05/2024",
//                            fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                        ,
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Total Durasi",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(127.dp))
                    Text(text = "2 Hari",
                            fontWeight = FontWeight.Bold,
                        modifier = Modifier
                        ,
                    )
                }

            }
        }


        Card (modifier = Modifier
            .padding(horizontal = 25.dp)
            .border(width = 1.dp, color = (cardStroke1), shape = RoundedCornerShape(7.dp)),
            colors = CardDefaults.cardColors(cardFill1),
            elevation = CardDefaults.cardElevation(4.dp),
        )
        {
            Column (modifier = Modifier
                .padding(12.dp)
                ,
//                horizontalAlignment = Alignment.CenterHorizontally
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
            MyButton2(onClick = { /* Lakukan sesuatu saat tombol diklik */ })
        }
    }



}

@Preview(showBackground = true, device = Devices.PIXEL_6_PRO)
@Composable
fun DefaultPreview() {
    CheckDone( pembayaran = Data.dataPembayaran)
}
