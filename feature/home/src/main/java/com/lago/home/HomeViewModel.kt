package com.lago.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.lago.model.IMovieRepository
import com.lago.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val movieRepository: IMovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    private var currentResult: Flow<PagingData<Movie>>? = null

    fun searchRepo(): Flow<PagingData<Movie>> {
        val newResult: Flow<PagingData<Movie>> = movieRepository.getMovies()
        currentResult = newResult
        return newResult
    }

    init {
        viewModelScope.launch {
            movieRepository.getMoviesTopRated().collect {
                _movies.value = it.results
            }
        }
    }
}
