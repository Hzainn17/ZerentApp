@file:OptIn(ExperimentalMaterial3Api::class)

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.zerentapp.data.Data.sampleStatus
import com.example.zerentapp.model.Status
import com.example.zerentapp.presentation.screen.Order.Order
import com.example.zerentapp.presentation.screen.Order.OrderViewModel
import com.example.zerentapp.presentation.screen.Order.ToolKit.OrderSearch
import com.example.zerentapp.presentation.screen.Order.ToolKit.RantingBarOrder
import com.example.zerentapp.ui.theme.color1

val garis = Color(android.graphics.Color.parseColor("#323232"))
val biggaris = Color(android.graphics.Color.parseColor("#E9F5FE"))

fun createImageLoader(context: Context): ImageLoader {
    return ImageLoader.Builder(context)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
}

@Composable
fun StatusScreen(status: MutableState<Status>) {
    Text(
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF043C5B),
        modifier = Modifier
            .padding(start = 50.dp)
            .padding(top = 10.dp)
        ,
        text = "Pesanan Saya"
    )
    Column(modifier = Modifier

        .padding(start = 10.dp, end = 10.dp, top = 15.dp)
        .width(800.dp)
        .offset(y = 50.dp,)
        .height(60.dp)
        .size(390.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(color = biggaris)
    ) {
    }
    OrderSearch()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        StatusSelection(statusList = sampleStatus, currentStatus = status)
        Spacer(modifier = Modifier.height(16.dp))
        StatusSection(status = status.value)

    }
}


@Composable
fun StatusSelection(
    statusList: List<Status>,
    currentStatus: MutableState<Status>,
    viewModel: OrderViewModel = hiltViewModel()) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier

    ) {
        item {

            Row {
                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .padding(top = 45.dp, )
                ) {
                    items(statusList) { status ->
                        Row {
                            Text(
                                text = "${status.name}",
                                modifier = Modifier
                                    .padding(horizontal = 10.dp,)
                                    .clip(RoundedCornerShape(10.dp))
                                    .clickable {
                                        currentStatus.value = status
                                        viewModel.fetchProductsByStatus(status.name)
                                    }
                                    .background(
                                        if (currentStatus.value == status) {
                                            Color(0xFF043C5B)
                                        } else {
                                            Color(0xFFE9F5FE)
                                        }
                                    )
                                    .padding(10.dp),
                                fontSize = 14.sp,
                                color = if (currentStatus.value == status) Color.White else Color.Black,
                                fontWeight = if (currentStatus.value == status) FontWeight.Bold else FontWeight.Medium ,
                            )
                        }
                    }
                }
            }
        }

    }

}
@Composable
fun StatusSection(
    status: Status,
    viewModel: OrderViewModel = hiltViewModel()
) {
    val rentals by viewModel.products.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
            .padding(vertical = 8.dp)

    ) {

        LazyColumn {
            items(rentals) { product ->
                BarangCard(product, navController = rememberNavController())

            }

        }
    }
}

@Composable
fun BarangCard(
    product: Order,
    viewModel: OrderViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val isSelected = remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }
    val rating = remember { mutableStateOf(product.productRanting) }
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current
    val imageLoader = createImageLoader(context)
    Card(
        modifier = Modifier

            .fillMaxWidth()
            .padding(vertical = 10.dp,)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .shadow(
                elevation = 7.dp,
                RoundedCornerShape(
                    topEnd = 10.dp,
                    topStart = 10.dp,
                    bottomEnd = 25.dp,
                    bottomStart = 25.dp,
                ),
                spotColor = Color.Black,
                ambientColor = Color.Black
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF),
        )
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = "Deposit",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(biggaris)
                        .padding(start = 10.dp, end = 10.dp,)
                        .padding(5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .padding(bottom = 10.dp)
                    .offset(y = 15.dp,)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
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
                        .clip(RoundedCornerShape(16.dp))
                        .size(height = 94.dp, width = 100.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = product.productName,
                        style = MaterialTheme.typography.titleSmall,

                        )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        //text = "Durasi : ${barang.waktu} Hari",
                        text = "Durasi : ${product.rentalDuration} Hari",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(

                        text = "${product.rentalStartDate} / ${product.rentalStartDate}",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ){
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp)
                    ,
                    text = "Rp${product.productHarga}/hari",)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .padding(end = 5.dp)
                    ,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Total:")
                Text(
                    modifier = Modifier
                        .padding(end = 15.dp, bottom = 10.dp)
                    ,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Rp 150.000")
            }
            Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp))
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .padding(start = 5.dp)
            ){
                Row(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .offset(y = -5.dp)
                ) {
                    if (product.rentalStatus == "digunakan"){
                        Text(
                            text = "Lapor kerusakan",
                            modifier = Modifier
                                .padding(horizontal = 10.dp,)
                                .clip(RoundedCornerShape(10.dp))
//                            .clickable {
//                                isSelected.value = !isSelected.value
//                                if (product.rentalStatus == "pending") {
//                                    viewModel.updateProductStatus(product.id, "digunakan")
//                                } else if (product.rentalStatus == "digunakan") {
//                                    viewModel.updateProductStatus(product.id, "selesai")
//                                }
//                            }
                                .background(
                                    if (isSelected.value) {
                                        Color(0xFFFFFFFF)
                                    } else {
                                        Color(0xFF043C5B)
                                    }
                                )
                                .border(
                                    width = 1.5.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    color = if (isSelected.value) Color(
                                        0xFF043C5B
                                    ) else Color(
                                        0xFF043C5B
                                    )
                                )

                                .padding(10.dp),
                            fontSize = 14.sp,
                            color = if (isSelected.value) Color(0xFF043C5B) else Color.White,
                            fontWeight = if (isSelected.value) FontWeight.Bold else FontWeight.Medium,

                            )
                    } else {
                        AsyncImage(
                            model = "https://example.com/test-image.jpg",
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .size(height = 35.dp, width = 35.dp)
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 10.dp, top = 7.dp),
                            text = "Toko Serba Ada",
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))

                    Row {
                        Text(
                            text = if (product.rentalStatus == "pending") {
                                "konfirmasi"
                            } else if (product.rentalStatus == "digunakan") {
                                "pengembalian"} else {"beri rating"},
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .clickable {
                                    isSelected.value = !isSelected.value
                                    showDialog.value = true
                                }
                                .background(
                                    if (isSelected.value) Color(0xFFFFFFFF) else Color(0xFF043C5B)
                                )
                                .border(
                                    width = 1.5.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    color = Color(0xFF043C5B)
                                )
                                .padding(10.dp),
                            fontSize = 14.sp,
                            color = if (isSelected.value) Color(0xFF043C5B) else Color.White,
                            fontWeight = if (isSelected.value) FontWeight.Bold else FontWeight.Medium
                        )
                    }

                    if (showDialog.value) {
                        AlertDialog(
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp)),
                            shape = RoundedCornerShape(
                                topEnd = 10.dp,
                                topStart = 10.dp,
                                bottomEnd = 10.dp,
                                bottomStart = 10.dp, ),
                            onDismissRequest = { showDialog.value = false },
                            confirmButton = {
                                Button(
                                    modifier = Modifier
                                        .padding(top = 90.dp)
                                        .padding(end = 20.dp, start = 20.dp)
                                        .clip(
                                            RoundedCornerShape(
                                                5.dp
                                            )
                                        )
                                        .background(color1)

                                        .size(width = 230.dp, height = 35.dp)
                                    ,

                                    shape = RoundedCornerShape(
                                        topEnd = 5.dp,
                                        topStart = 5.dp,
                                        bottomEnd = 5.dp,
                                        bottomStart = 5.dp, ),
                                    onClick = {
                                        if (product.rentalStatus == "pending") {
                                            viewModel.updateProductStatus(product.id, "digunakan")
                                        } else if (product.rentalStatus == "digunakan") {
                                            viewModel.updateProductStatus(
                                                product.id,
                                                "selesai"
                                            )
                                        } else {
                                            product.productRanting = rating.value
                                            viewModel.updateProductStatus(
                                                product.id,
                                                "selesai"
                                            )
                                        }
                                        showDialog.value = false

                                    }

                                ) {
                                    Text(
                                        color = Color.White,
                                        text= "Konfirmasi",)
                                }
                            },
//                            dismissButton = {
//                                TextButton(
//                                    onClick = { showDialog.value = false }
//                                ) {
//                                    Text("Cancel")
//                                }
//                            },

                            text = {
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp)
                                    ,
                                    horizontalArrangement = Arrangement.Absolute.spacedBy(300.dp)){
                                    Box{
                                        if (product.rentalStatus == "pending") {
                                            Column(modifier = Modifier
                                                .padding(start = 25.dp)){
                                                Text(
                                                    text = "Konfirmasi",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 20.sp,
                                                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp)
                                                )
                                                Text("Ingin  Mensewah Barang ?")
                                            }
                                        } else if (product.rentalStatus == "digunakan") {
                                            Column(modifier = Modifier
                                                .padding(start = 25.dp)){
                                                Text(
                                                    text = "Pengembalian",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 20.sp,
                                                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
                                                )
                                                Text(
                                                    text = "Apa Anda Yakin ?",
                                                    modifier = Modifier.padding(horizontal = 30.dp)
                                                )
                                            }
                                        } else {
                                            Text(
                                                text = "Beri Rating",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 20.sp,
                                                modifier = Modifier
                                                    .padding(horizontal = 60.dp, vertical = 15.dp)
                                                    .height(300.dp)
                                            )
                                            RantingBarOrder(rating = rating)
                                            Row(
                                                modifier = Modifier

                                                ,
                                            ) {
                                                Column{
                                                    TextField(
                                                        value = text,
                                                        onValueChange = { text = it },
                                                        label = { Text("Beri Kami Alasan Nya") },
                                                        modifier = Modifier
                                                            .offset(y = 155.dp)
                                                            .border(
                                                                2.dp,
                                                                Color.Black,
                                                                RoundedCornerShape(5.dp)
                                                            )
                                                            .size(height = 220.dp, width = 300.dp),
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
                                                }


                                            }
                                        }
                                    }
                                    Column {

                                    }
                                }


                            }
                        )
                    }
                }


            }
        }
    }
}




@Composable
fun Order(navController: NavHostController) {
    val currentStatus = remember { mutableStateOf(sampleStatus[0]) }

    Surface(color = MaterialTheme.colorScheme.background) {
        StatusScreen(status = currentStatus)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Order(navController = rememberNavController())
}
