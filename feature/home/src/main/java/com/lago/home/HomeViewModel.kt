package com.lago.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
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
    private val movieRepository: IMovieRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private lateinit var currentResult: Flow<PagingData<Movie>>

    fun searchRepo(): Flow<PagingData<Movie>> {
        val newResult: Flow<PagingData<Movie>> = movieRepository.getMovies()
        currentResult = newResult
        return newResult
    }
}
