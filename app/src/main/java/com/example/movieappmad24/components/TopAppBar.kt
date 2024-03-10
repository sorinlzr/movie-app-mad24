package com.example.movieappmad24.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(name: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color(0xFFEADDFF))
            .fillMaxWidth()
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF6852A5),
            modifier = Modifier
                .padding(14.dp)
        )
    }
}