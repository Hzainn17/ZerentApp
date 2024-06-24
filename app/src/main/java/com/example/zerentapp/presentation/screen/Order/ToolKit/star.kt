package com.example.zerentapp.presentation.screen.Order.ToolKit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun RantingBarOrder(rating: MutableState<String>) {
    val ratingInt = rating.value.toIntOrNull() ?: 0
    Row(
        modifier = Modifier
            .padding(top = 75.dp),
        horizontalArrangement = Arrangement.Absolute.spacedBy(20.dp)) {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= ratingInt) Icons.Filled.Star else Icons.Outlined.StarOutline,
                contentDescription = "Star",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        rating.value = i.toString()
                    },
                tint = if (i <= ratingInt) Color(0xFFFFD700) else Color.Gray
            )
        }
    }
}
