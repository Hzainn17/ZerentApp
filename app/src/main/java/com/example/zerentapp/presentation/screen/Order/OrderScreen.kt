@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.zerentapp.data.Data.sampleStatus
import com.example.zerentapp.model.Status
import com.example.zerentapp.presentation.screen.Order.Order
import com.example.zerentapp.presentation.screen.Order.ToolKit.OrderSearch
import com.example.zerentapp.presentation.screen.Order.OrderViewModel
import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder

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
                BarangCard(product)

            }

        }
    }
}

@Composable
fun BarangCard(
    product: Order,
    viewModel: OrderViewModel = hiltViewModel(),
    ) {
    val isSelected = remember { mutableStateOf(false) }
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
                AsyncImage(
                    model = "https://example.com/test-image.jpg", // Use a simple test image URL
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(height = 35.dp, width = 35.dp)
                )
                Text(modifier = Modifier
                    .padding(start = 10.dp, top = 7.dp)
                    ,
                    text = "Toko Serba Ada",)
                Spacer(modifier = Modifier.weight(1f))
                Row(

                    modifier = Modifier
                        .padding(end = 8.dp)
                        .offset(y = -5.dp)


                ) {
                    Row {
                        Text(
//                            text = "${barang.button_action}",
                            text = "konfirmasi",
                            modifier = Modifier

                                .padding(horizontal = 10.dp,)
                                .clip(RoundedCornerShape(10.dp))
                                .clickable {
                                    isSelected.value = !isSelected.value
                                    if (isSelected.value) {
                                        viewModel.updateProductStatus(product.id, "selesai")
                                    }
                                }
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

                                .padding(10.dp)

                            ,
                            fontSize = 14.sp,
                            color = if (isSelected.value) Color(0xFF043C5B) else Color.White,
                            fontWeight = if (isSelected.value) FontWeight.Bold else FontWeight.Medium ,

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
