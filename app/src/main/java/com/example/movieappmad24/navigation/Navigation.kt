package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.Screen

@Composable
fun Navigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route + "/{movieId}",
            arguments = listOf(navArgument(name = "movieId") { type = NavType.StringType })
        )
        { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId");
            val movie = getMovies().find { it.id == movieId } !!
            DetailScreen(
                movie = movie,
                navController = navController)
        }
    }
}