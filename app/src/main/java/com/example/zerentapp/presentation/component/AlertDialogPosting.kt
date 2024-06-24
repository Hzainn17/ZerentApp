package com.example.zerentapp.presentation.component

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogPosting(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    namaBarang: String,
    hargaSewa: String,
    deposit: String,
    imageUri: Uri?, // Tambahkan parameter imageUri
    onSave: (String, String, String) -> Unit,

) {
    var selectedCity by remember { mutableStateOf("") }
    var selectedDistrict by remember { mutableStateOf("") }
    var no by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},
        modifier = Modifier.height(550.dp),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Tambahkan Lokasi",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                item {
                    // Isi dialog dengan field-field lainnya...

                    Text(text = "Kota", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(5.dp))

                    ExposedDropdownItem(items = arrayOf("bandung", "semarang", "jakarta")) { selectedCity = it }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Kecamatan", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(5.dp))

                    ExposedDropdownItem(items = arrayOf("cibaduyut", "ciasem", "cimanis")) { selectedDistrict = it }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "No", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = no,
                        onValueChange = { no = it },
                        modifier = modifier
                            .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                            .background(Color.White, RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { onSave(selectedCity, selectedDistrict, no) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xff043C5B)
                            ),
                            modifier = Modifier
                                .width(120.dp)
                                .height(48.dp)
                        ) {
                            Text(text = "Terapkan", color = Color.White)
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownItem(items: Array<String>, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }

    Box {
        TextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(4.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp)),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown",
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            },
            readOnly = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        selectedItem = item
                        expanded = false
                        onSelected(item)
                    }
                )
            }
        }
    }
}
