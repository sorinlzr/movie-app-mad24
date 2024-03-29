package com.example.movieappmad24.components.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie

@Composable
fun MovieRow(
    movie: Movie,
    onItemClick: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .shadow(8.dp, shape = MaterialTheme.shapes.medium)
    ) {
        Card(
            modifier = Modifier.clickable {
                onItemClick(movie.id)
            }
        ) {
            MovieGraphics(movie)
            MovieText(movie)
        }
    }
}