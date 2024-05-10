package com.example.movieappmad24.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert
    fun add(movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Transaction
    @Query("SELECT * FROM movie where movie.id LIKE :movieId")
    fun get(movieId: String): Flow<MovieWithImages>

    @Transaction
    @Query("SELECT * FROM movie")
    fun getAll(): Flow<List<MovieWithImages>>

    @Transaction
    @Query("SELECT * FROM movie WHERE isFavorite IS TRUE")
    fun getFavorites(): Flow<List<MovieWithImages>>
}