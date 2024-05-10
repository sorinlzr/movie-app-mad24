package com.example.movieappmad24.models

import androidx.room.Embedded
import androidx.room.Relation

class MovieWithImages (
    @Embedded var movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
    var images: List<MovieImage>
)
