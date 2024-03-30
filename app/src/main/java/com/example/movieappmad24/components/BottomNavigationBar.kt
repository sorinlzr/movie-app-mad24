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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieappmad24.screens.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomAppBar {
        NavigationBarItem(
            selected = currentRoute == Screen.Home.route,
            onClick = { navController.navigate(Screen.Home.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    tint = Color.Black,
                    contentDescription = "Home_icon"
                )
            },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentRoute == Screen.Watchlist.route,
            onClick = { navController.navigate(Screen.Watchlist.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    tint = Color.Black,
                    contentDescription = "Watchlist_icon"
                )
            },
            label = { Text("Watchlist") }
        )
    }
}