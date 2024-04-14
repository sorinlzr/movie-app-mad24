package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.components.appBar.SimpleBottomAppBar
import com.example.movieappmad24.components.appBar.SimpleTopAppBar
import com.example.movieappmad24.components.movie.MovieRow
import com.example.movieappmad24.components.videoPlayer.VideoPlayer
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieViewModel

@Composable
fun DetailScreen(
    movie: Movie,
    navController: NavController,
    moviesViewModel: MovieViewModel
) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(name = movie.title,
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
            item {
                MovieRow(
                    movie,
                    onItemClick = { movieId ->
                        navController.navigate(Screen.Detail.route + "/${movieId}")
                    },
                    onFavoriteIconClick = { movieId ->
                        moviesViewModel.toggleFavorite(movieId)
                    }
                )
            }
            item { VideoPlayer(movie = movie) }
            item {
                LazyRow(Modifier.padding(5.dp)) {
                    items(movie.images) { imageUrl ->
                        Card(
                            modifier = Modifier
                                .padding(5.dp, 5.dp, 10.dp, 5.dp)
                                .height(300.dp)
                                .width(300.dp)
                        ) {
                            AsyncImage(
                                model = imageUrl,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize(),
                                contentDescription = "Image of the ${movie.title} movie"
                            )
                        }
                    }
                }
            }
        }
    }
}
