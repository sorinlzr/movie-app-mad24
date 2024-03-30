package com.example.movieappmad24.utils

import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import kotlin.random.Random

class MovieService(private val allMovies: List<Movie> = getMovies()) {
    private var cachedMovies: List<Movie>? = null

    fun getWatchlist(): List<Movie> {
        if (cachedMovies == null) {
            cachedMovies = generateRandomMovies()
        }
        return cachedMovies!!
    }

    private fun generateRandomMovies(): List<Movie> {
        val shuffledMovies = allMovies.shuffled(Random(42))
        return shuffledMovies.take(3)
    }

    fun isFavorite(movieId: String): Boolean {
        return getWatchlist().any { it.id == movieId }
    }
}