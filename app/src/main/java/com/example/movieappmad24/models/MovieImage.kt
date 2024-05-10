package com.example.movieappmad24.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MovieImage (
    @ColumnInfo(defaultValue = "0")
    @PrimaryKey
    var id: Long,
    var movieId: String,
    var url: String
) {

}