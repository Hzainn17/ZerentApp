package com.example.zerentapp.presentation.screen.PostingProduct

//import PostingViewModel
import android.net.Uri // Add this import statement
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.AlertDialogPosting
//import com.example.zerentapp.presentation.screen.PostingProduct.PostingViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostingProductScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PostingViewModel = viewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    var namaBarang by remember { mutableStateOf("") }
    var hargaSewa by remember { mutableStateOf("") }
    var deposit by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var jarak by remember { mutableStateOf("3") }
    var rating by remember { mutableStateOf("5") }
    var namaPenjual by remember { mutableStateOf("Seller") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val permissionToRequest = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Manifest.permission.READ_MEDIA_IMAGES
    } else {
        Manifest.permission.READ_EXTERNAL_STORAGE
    }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }
    val permissionLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            launcher.launch("image/*")
        } else {
            // Handle permission denial if needed
        }
    }

    if (showDialog) {
        AlertDialogPosting(
            onDismiss = { showDialog = false },
            namaBarang = namaBarang,
            hargaSewa = hargaSewa,
            deposit = deposit,
            imageUri = imageUri, // Teruskan imageUri di sini
            onSave = { city, district, no ->
                viewModel.saveProduct(
                    nama = namaBarang,
                    harga = hargaSewa,
                    deposit = deposit,
                    kota = city,
                    kecamatan = district,
                    no = no,
                    imageUri = imageUri?.toString() ?: "", // Pastikan Anda mengonversi Uri menjadi String jika diperlukan
                    deskripsi = deskripsi,
                    rating = rating,
                    jarak = jarak,
                    namaPenjual = namaPenjual
                )
                showDialog = false
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B)
                )
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp)
                ) {
                    Box(modifier = Modifier) {
                        imageUri?.let {
                            Image(
                                painter = rememberImagePainter(data = it),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(360.dp)
                                    .height(200.dp)
                                    .clickable {
                                        val isGranted = ContextCompat.checkSelfPermission(
                                            context, permissionToRequest
                                        ) == PackageManager.PERMISSION_GRANTED

                                        if (isGranted) {
                                            launcher.launch("image/*")
                                        } else {
                                            permissionLauncher.launch(permissionToRequest)
                                        }
                                    }
                            )
                        } ?: run {
                            Image(
                                painter = painterResource(id = R.drawable.ic_tambahfotoproduct),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(360.dp)
                                    .height(200.dp)
                                    .clickable {
                                        val isGranted = ContextCompat.checkSelfPermission(
                                            context, permissionToRequest
                                        ) == PackageManager.PERMISSION_GRANTED

                                        if (isGranted) {
                                            launcher.launch("image/*")
                                        } else {
                                            permissionLauncher.launch(permissionToRequest)
                                        }
                                    }
                            )
                        }
                    }
                }
            }

            item {
                TextField(
                    value = namaBarang,
                    onValueChange = { namaBarang = it },
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(320.dp)
                        .height(60.dp)
                        .padding(horizontal = 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = { Text(text = "Nama Barang") }
                )
            }

            item {
                TextField(
                    value = deskripsi,
                    onValueChange = { deskripsi = it },
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(320.dp)
                        .height(60.dp)
                        .padding(horizontal = 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = { Text(text = "Deskripsi Barang") }
                )
            }

            item {
                TextField(
                    value = hargaSewa,
                    onValueChange = { hargaSewa = it },
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(320.dp)
                        .height(60.dp)
                        .padding(horizontal = 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = { Text(text = "harga Sewa Barang") }
                )
            }


            item {
                TextField(
                    value = deposit,
                    onValueChange = { deposit = it },
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(320.dp)
                        .height(60.dp)
                        .padding(horizontal = 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = { Text(text = "Deposit") }
                )
            }



            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { showDialog = true },
                        modifier = Modifier
                            .width(300.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xff043C5B),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "SIMPAN",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PostingProductPrev() {
    PostingProductScreen(navController = rememberNavController())
}
