package com.example.movieappmad24.components.movie

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieappmad24.models.Movie

@Composable
fun MovieText(movie: Movie) {
    var showMovieDetails by remember {
        mutableStateOf(false)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clickable { showMovieDetails = !showMovieDetails }
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
            imageVector = if (showMovieDetails) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = "arrow_up_icon"
        )
    }
    AnimatedVisibility(visible = showMovieDetails) {
        MovieDetails(movie)
    }
}