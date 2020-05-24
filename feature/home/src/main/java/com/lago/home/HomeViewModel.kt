package com.lago.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lago.model.IMovieRepository
import com.lago.model.Movie
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @AssistedInject constructor(
    private val movieRepository: IMovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    init {
        viewModelScope.launch {
            movieRepository.getMoviesTopRated().collect {
                _movies.value = it.results
            }
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): HomeViewModel
    }
}
