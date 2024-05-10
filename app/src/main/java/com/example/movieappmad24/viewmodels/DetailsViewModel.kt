package com.example.movieappmad24.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.models.MovieWithImages

class DetailsViewModel (
    private val repository: MovieRepository,
) : ViewModel()  {
    val movie = MutableLiveData<MovieWithImages>()

    fun getMovieById(id: String) = repository.getById(id)
}