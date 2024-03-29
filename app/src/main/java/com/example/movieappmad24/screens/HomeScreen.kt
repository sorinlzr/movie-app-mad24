package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.movieappmad24.R
import com.example.movieappmad24.components.BottomNavigationBar
import com.example.movieappmad24.components.TopAppBar
import com.example.movieappmad24.components.movie.MovieRow
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

@Composable
fun HomeScreen(navController: NavController) {
    MovieList(navController = navController)
}

@Composable
fun MovieList(movies: List<Movie> = getMovies(), navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(name = stringResource(id = R.string.app_name)) },
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { BottomNavigationBar() }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(movies) { movie ->
                MovieRow(movie) { movieId ->
                    navController.navigate(Screen.Detail.route + "/${movieId}")
                }
            }
        }
    }
}