package com.example.zerentapp.presentation.screen.Detail.ToolKit


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons

import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp

@Composable
fun HeaderDetail(

    modifier: Modifier = Modifier,

    ) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {

        Column {

            Text(
                modifier = modifier
                    .offset(y = 15.dp, x = 15.dp),
                text = "Detail", style = MaterialTheme.typography.bodyLarge)
        }

    }

}