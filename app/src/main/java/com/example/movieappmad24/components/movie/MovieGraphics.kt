package com.example.movieappmad24.components.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage

@Composable
fun MovieGraphics(
    movie: Movie,
    movieImages: List<MovieImage>,
    onFavoriteIconClick: (String) -> Unit = {},
) {
    Box {
        AsyncImage(
            model = movieImages[0].url,
            contentDescription = "placeholder_image"
        )
        Icon(
            imageVector = if (movie.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            tint = Color.White,
            contentDescription = "favorite_icon",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(all = 8.dp)
                .clickable { onFavoriteIconClick(movie.id) }
        )
    }
}