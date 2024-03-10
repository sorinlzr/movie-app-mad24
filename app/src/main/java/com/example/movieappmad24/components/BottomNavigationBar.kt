package com.example.movieappmad24.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar() {
    BottomAppBar {
        NavigationBarItem(selected = true, onClick = {}, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                tint = Color.Black,
                contentDescription = "Home_icon"
            )
        }, label = { Text("Home") })
        NavigationBarItem(selected = false, onClick = {}, icon = {
            Icon(
                imageVector = Icons.Default.Star,
                tint = Color.Black,
                contentDescription = "Home_icon"
            )
        }, label = { Text("Watchlist") })
    }
}