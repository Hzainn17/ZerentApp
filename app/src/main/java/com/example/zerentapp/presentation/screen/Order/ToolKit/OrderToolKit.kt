package com.example.zerentapp.presentation.screen.Order.ToolKit

import androidx.compose.material.icons.filled.History

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderSearch() {

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }


    var searchHistory = remember { mutableListOf(
        "Kamera EOS 50D",
        "Kamera Mainan",
    ) }
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = if (active) 1.dp else 125.dp,)
            .padding(start = if (active)  0.dp else 25.dp, end = if (active) 0.dp else 25.dp)


        ,
        query = query,
        onQueryChange = { query = it },
        onSearch = { newQuery ->
            searchHistory.add(query)
            active = false
            println("Performing search on query: $newQuery")
        },

        active = active,
        onActiveChange = { active = it },
        placeholder = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
        },
        trailingIcon = {
            Row {
                IconButton(onClick = { /* open mic dialog */ }) {
                        }
                if (active) {
                    IconButton(
                        onClick = { if (query.isNotEmpty()) query = "" else active = false }
                    ) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                    }
                }
            }
        }
    ) {
        searchHistory.takeLast(3).forEach { item ->
            ListItem(
                modifier = Modifier.clickable { query = item },
                headlineContent = { Text(text = item) },
                leadingContent = {
                    Icon(imageVector =   Icons.Default.History, contentDescription = "history",)
                }
            )
        }
    }
}
