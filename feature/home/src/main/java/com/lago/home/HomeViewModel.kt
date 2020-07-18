package com.lago.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.lago.core.util.Event
import com.lago.model.IMovieRepository
import com.lago.model.Movie
import kotlinx.coroutines.flow.Flow

class HomeViewModel @ViewModelInject constructor(
    private val movieRepository: IMovieRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _init = MutableLiveData<Event<Unit>>()
    val init: LiveData<Event<Unit>>
        get() = _init

    private lateinit var currentResult: Flow<PagingData<Movie>>

    init {
        _init.value = Event(Unit)
    }

    fun searchRepo(): Flow<PagingData<Movie>> {
        val newResult: Flow<PagingData<Movie>> = movieRepository.getMovies()
        currentResult = newResult
        return newResult
    }
}
