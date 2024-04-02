package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.components.appBar.SimpleBottomAppBar
import com.example.movieappmad24.components.appBar.SimpleTopAppBar
import com.example.movieappmad24.components.movie.MovieRow
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieViewModel

@Composable
fun WatchlistScreen(
    movies: List<Movie>,
    navController: NavController,
    moviesViewModel: MovieViewModel
) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(name = "My Watchlist",
                backIcon = true,
                onBackIconClick = { navController.popBackStack() })
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
            items(movies) { movie ->
                MovieRow(movie,
                    onItemClick = { movieId ->
                        navController.navigate(Screen.Detail.route + "/${movieId}")
                    },
                    onFavoriteIconClick = { movieId ->
                        moviesViewModel.toggleFavorite(movieId)
                    }
                )
            }
        }
    }
}