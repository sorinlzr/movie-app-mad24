package com.example.movieappmad24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card {
                        Image(
                            painter = painterResource(id = R.drawable.movie_image),
                            contentDescription = "placeholder_image"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TopAppBar(name: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color(0xFFEADDFF))
            .fillMaxWidth()
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF6852A5),
            modifier = Modifier
                .padding(14.dp)
        )
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Column(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .shadow(8.dp, shape = MaterialTheme.shapes.medium)
    ) {
        Card {
            MovieGraphics(movie)
            MovieText(movie)
        }
    }
}

@Composable
fun MovieGraphics(movie: Movie) {
    Box {
        AsyncImage(
            model = movie.images[0],
            contentDescription = "placeholder_image"
        )
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            tint = Color.White,
            contentDescription = "favorite_icon",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(all = 8.dp)
        )
    }
}

@Composable
fun MovieText(movie: Movie) {
    var showMovieDetails by remember {
        mutableStateOf(false)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 4.dp)
    )
    {
        Text(
            movie.title,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterVertically)
        )
        Icon(
            modifier = Modifier.clickable { showMovieDetails = !showMovieDetails },
            imageVector = if (showMovieDetails) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
            contentDescription = "arrow_up_icon"
        )
    }
    if (showMovieDetails) {
        MovieDetails(movie)
    }
}

@Composable
fun MovieDetails(movie: Movie) {
    Column(modifier = Modifier.padding(top = 5.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)) {
        Text(
            "Director: ${movie.director}"
        )
        Text(
            "Released: ${movie.year}"
        )
        Text(
            "Genre: ${movie.genre}"
        )
        Text(
            "Actors: ${movie.actors}"
        )
        Text(
            "Rating: ${movie.rating}"
        )
        Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 5.dp))
        Text(
            "Plot: ${movie.plot}"
        )
    }
}


@Composable
fun BottomAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .background(color = Color(0xFFF3EDF9))
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Home,
                tint = Color.Black,
                contentDescription = "Home_icon"
            )
            Text(text = "Home")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Star,
                tint = Color.Black,
                contentDescription = "Watchlist_icon"
            )
            Text(text = "Watchlist")
        }
    }
}

@Composable
fun MovieList(movies: List<Movie> = getMovies()) {
    Scaffold(
        topBar = { TopAppBar(name = stringResource(id = R.string.app_name)) },
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { BottomAppBar() }) { innerPadding ->
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