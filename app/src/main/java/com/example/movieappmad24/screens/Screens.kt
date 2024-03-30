package com.example.movieappmad24.screens

sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")
    data object Detail: Screen(route = "detail")
    data object Watchlist: Screen(route = "watchlist")

}
