package com.example.zerentapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var search by remember { mutableStateOf("") }

    TextField(
        value = search, // Set the initial value
        onValueChange = { search = it }, // Update state on change
        modifier = modifier
            .border( // Black border with rounded corners
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .background(Color.White, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(30.dp)
            .padding(horizontal = 16.dp), // Add horizontal padding

        leadingIcon = { // Search icon on the left
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors( // Optional: customize colors
            containerColor = Color.Transparent, // Make background transparent
            focusedIndicatorColor = Color.Transparent, // Remove selection highlight
            unfocusedIndicatorColor = Color.Transparent // Remove unfocused indicator
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPrev() {
    SearchBar()
}