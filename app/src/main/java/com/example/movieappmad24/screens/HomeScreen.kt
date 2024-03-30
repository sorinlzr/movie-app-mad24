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
import com.example.movieappmad24.components.appBar.SimpleBottomAppBar
import com.example.movieappmad24.components.appBar.SimpleTopAppBar
import com.example.movieappmad24.components.movie.MovieRow
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.utils.MovieService

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(name = stringResource(id = R.string.app_name))
        },
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            SimpleBottomAppBar(navController)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(getMovies()) { movie ->
                val isFavorite = MovieService().isFavorite(movie.id)
                MovieRow(movie, isFavorite) { movieId ->
                    navController.navigate(Screen.Detail.route + "/${movieId}")
                }
            }
        }
    }
}