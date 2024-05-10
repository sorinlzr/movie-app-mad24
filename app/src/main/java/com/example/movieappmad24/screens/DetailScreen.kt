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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.components.appBar.SimpleBottomAppBar
import com.example.movieappmad24.components.appBar.SimpleTopAppBar
import com.example.movieappmad24.components.movie.MovieRow
import com.example.movieappmad24.components.videoPlayer.VideoPlayer
import com.example.movieappmad24.data.MovieDatabase
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.viewmodels.DetailsViewModel
import com.example.movieappmad24.viewmodels.FavoritesViewModel
import com.example.movieappmad24.viewmodels.MoviesViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(
    movieId: String,
    navController: NavController
) {
    val db = MovieDatabase.getDatabase(LocalContext.current)
    val repository = MovieRepository(movieDao = db.movieDao())
    val factory = MoviesViewModelFactory(repository = repository)
    val viewModel: DetailsViewModel = viewModel(factory = factory)
    val favoritesViewModel: FavoritesViewModel = viewModel(factory = factory)

    val movie = viewModel.getMovieById(movieId).collectAsState(initial = null).value

    movie?.let{
        Scaffold(
            topBar = {
                SimpleTopAppBar(name = movie.movie.title,
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
                        onFavoriteIconClick = {
                            viewModel.viewModelScope.launch(Dispatchers.IO)  {
                                favoritesViewModel.toggleFavorite(movie)
                            }
                        }
                    )
                }
                item { VideoPlayer(movie = movie.movie) }
                item {
                    LazyRow(Modifier.padding(5.dp)) {
                        items(movie.images) { image ->
                            Card(
                                modifier = Modifier
                                    .padding(5.dp, 5.dp, 10.dp, 5.dp)
                                    .height(300.dp)
                                    .width(300.dp)
                            ) {
                                AsyncImage(
                                    model = image.url,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize(),
                                    contentDescription = "Image of the ${movie.movie.title} movie"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
