package com.example.zerentapp.presentation.screen.Detail.ToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlarm
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Discount
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.navigation.Screen
import com.example.zerentapp.presentation.screen.Detail.Detail
import com.example.zerentapp.presentation.screen.Detail.DetailViewModel
import com.example.zerentapp.presentation.screen.Detail.Rental
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.delay
import java.util.Date


@Composable
fun PopingButton(
    detail: Detail,
    navController: NavController,
    showPopupInitially: Boolean = false,
    onPostRental: (Rental) -> Unit,
    viewModel: DetailViewModel = hiltViewModel(),
) {
//    var showPop by remember { mutableStateOf(false) }
    var showPop by remember { mutableStateOf(showPopupInitially) }
    val garis = Color(android.graphics.Color.parseColor("#323232"))
    var hari by remember { mutableStateOf(1) }

    var productName by remember { mutableStateOf("") }
    var productHarga by remember { mutableStateOf("") }
    var productImage by remember { mutableStateOf("") }
    var productStatus by remember { mutableStateOf("") }
    var rentalEndDate by remember { mutableStateOf("") }
    var rentalStartDate by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    var rentalStatus by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var rentalDuration by remember { mutableStateOf("") }

    val handlePostRental = {
        val (rentalStartDate, rentalEndDate) = viewModel.calculateRentalDates(hari)
        val rental = Rental(
            productName = detail.productName,
            productHarga = detail.productHarga,
            productImage = detail.productImage,
            rentalEndDate = rentalEndDate,
            rentalStartDate = rentalStartDate,
            userId = "uR5Fv63aBSXzurFH5K9i9pvZDs13",
            rentalStatus = "pending",
            rentedAt = Date(),
            quantity = 1,
            rentalDuration = hari,
        )
        onPostRental(rental)}
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { showPop = true },
            modifier = Modifier.size(width = 195.dp, height = 50.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF043C5B)),
            shape = RectangleShape
        ) {
            Text(
                text = "Checkout",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }
    }


    if (showPop) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
        )
            AlertDialog(
                modifier = Modifier
//                    .fillMaxSize()
                    .fillMaxWidth()
//                    .size(width = 390.dp, height = 335.dp)
                ,
                shape =  RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 20.dp,
                    bottomEnd = 20.dp,
                    bottomStart = 20.dp,
                    ),
                onDismissRequest = { showPop = false },
                text = {
                    Column (
                        modifier = Modifier,
                    ){
                            Row {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    modifier = Modifier
                                        .padding(vertical = 4.dp),
                                    text = "Temoyang, Bulang")
                            }

                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))

                        Row (
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddAlarm,
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
//                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                ,
                            ) {
                                Button(
                                    onClick = { if (hari > 0) hari-- }, // Decrement value, ensure it doesn't go below 0
                                    modifier = Modifier
                                        .size(20.dp)
//                                        .padding(end = 8.dp)
                                    ,
                                    shape = CircleShape,
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    Text(text = "-")
                                }
                                Text(
                                    modifier = Modifier.padding(vertical = 4.dp)
                                        .padding(horizontal = 15.dp)
                                    ,
                                    text = hari.toString()
                                )
                                Button(
                                    onClick = { hari++ }, // Increment value
                                    modifier = Modifier
                                        .size(20.dp)
//                                        .padding(end = 8.dp)
                                    ,
                                    shape = CircleShape,
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    Text(text = "+")
                                }
                            }
                        }


                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))

                        Row {
                            Icon(
                                imageVector = Icons.Default.CalendarMonth,
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp),
                                text = "11/11/2024 - 12/12/2025")
                        }
                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))

                        Row {
                            Icon(imageVector = Icons.Default.Discount,
                                contentDescription = null,
                                modifier = Modifier.size(32.dp))

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp),
                                text = "Rp.123.000")
                        }
                        Divider(color = garis, thickness = 0.9.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp))
                    }
                },
                confirmButton = {
                    Button(
                        modifier = Modifier
                            .size(width = 130.dp, height = 35.dp)
                        ,

                        shape =  RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp, ),
                        onClick = {
                            showPop = false
                            navController.navigate("check")
                            handlePostRental()
                        }
                    ) {
                        Text("Pesan")
                    }
                },
                dismissButton = {
                    OutlinedButton(
                        modifier = Modifier

                            .size(width = 130.dp, height = 35.dp)
                        ,
                        shape =  RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp, ),
                        onClick = { showPop = false
                            navController.navigate(Screen.Whishlist.route)
                        }
                    ) {
                        Text("Wishlist")
                    }
                }
            )
        }
}

//@Preview(showBackground = true)
//@Composable
//fun PopingButtonPreview() {
//    val navController = rememberNavController()
//    PopingButton(navController)
//}

//@Preview(showBackground = true)
//@Composable
//fun PopingButtonWithPopupPreview() {
//    val navController = rememberNavController()
//    PopingButton(navController, showPopupInitially = true)
//}