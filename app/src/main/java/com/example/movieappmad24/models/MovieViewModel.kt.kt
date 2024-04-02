package com.example.movieappmad24.models

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel() {
    private val _movies = getMovies().toMutableStateList()

    val movieList: List<Movie>
        get() = _movies

    val favoriteList: List<Movie>
        get() = _movies.filter { movie: Movie -> movie.isFavorite }

    fun toggleFavorite(movieId: String) {
        _movies.find {
            it.id == movieId }?.let {
            foundMovie: Movie ->  foundMovie.isFavorite = !foundMovie.isFavorite
        }
    }
}