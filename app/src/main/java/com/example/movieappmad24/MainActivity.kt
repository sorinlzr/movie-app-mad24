package com.example.movieappmad24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappmad24.components.BottomNavigationBar
import com.example.movieappmad24.components.TopAppBar
import com.example.movieappmad24.components.movie.MovieCard
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList()
                }
            }
        }
    }
}

@Composable
fun MovieList(movies: List<Movie> = getMovies()) {
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
                MovieCard(movie)
            }
        }
    }

}

@Preview
@Composable
fun DefaultPreview() {
    MovieList()
}