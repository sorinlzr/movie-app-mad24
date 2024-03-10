package com.example.movieappmad24.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie

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