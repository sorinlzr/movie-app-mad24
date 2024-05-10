package com.example.movieappmad24.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val repository: MovieRepository,
) : ViewModel() {

    suspend fun toggleFavorite(movie: MovieWithImages) {
            movie.movie.isFavorite = !movie.movie.isFavorite
            repository.updateMovie(movie.movie)
    }

    private val _favoriteMovies = MutableStateFlow(listOf<MovieWithImages>())
    val favoriteMovies: StateFlow<List<MovieWithImages>> = _favoriteMovies.asStateFlow()


    init {
        viewModelScope.launch {
            repository.getFavoriteMovies().distinctUntilChanged()
                .collect { favorites -> _favoriteMovies.value = favorites }
        }
    }

}