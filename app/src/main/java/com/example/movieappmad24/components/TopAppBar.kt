package com.example.movieappmad24.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    name: String,
    backIcon: Boolean = false,
    onBackIconClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color(0xFFEADDFF))
            .fillMaxWidth()
    ) {
        if (backIcon) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(14.dp)
                    .clickable { onBackIconClick() }
            )
        } else {
            Spacer(modifier = Modifier.padding(14.dp))
        }

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF6852A5),
            modifier = Modifier
                .padding(14.dp)
        )
        Spacer(modifier = Modifier.padding(14.dp))
    }
}