package com.example.movieappmad24.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.movieappmad24.models.MovieImage

@Dao
interface MovieImageDao {
    @Insert
    fun add(movieImage: MovieImage)

    @Delete
    fun delete(movieImage: MovieImage)

    @Update
    fun update(movieImage: MovieImage)
}