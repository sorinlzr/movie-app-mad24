package com.example.movieappmad24.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey
    var id: String,
    var title: String,
    var year: String,
    var genre: String,
    var director: String,
    var actors: String,
    var plot: String,
    var trailer: String,
    var rating: String,
    var isFavorite: Boolean = false,
)

