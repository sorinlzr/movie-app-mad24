package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.components.appBar.SimpleBottomAppBar
import com.example.movieappmad24.components.appBar.SimpleTopAppBar
import com.example.movieappmad24.components.movie.MovieRow
import com.example.movieappmad24.data.MovieDatabase
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.viewmodels.FavoritesViewModel
import com.example.movieappmad24.viewmodels.MoviesViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WatchlistScreen(
    navController: NavController,
) {
    val db = MovieDatabase.getDatabase(LocalContext.current)
    val repository = MovieRepository(movieDao = db.movieDao())
    val factory = MoviesViewModelFactory(repository = repository)
    val favoritesViewModel: FavoritesViewModel = viewModel(factory = factory)

    val movies = favoritesViewModel.favoriteMovies.collectAsState().value

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
                    onFavoriteIconClick = {
                        favoritesViewModel.viewModelScope.launch(Dispatchers.IO) {
                            favoritesViewModel.toggleFavorite(movie)
                        }
                    }
                )
            }
        }
    }
}