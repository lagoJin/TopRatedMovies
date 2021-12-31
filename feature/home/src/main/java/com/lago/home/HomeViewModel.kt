package com.lago.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.lago.core.util.Event
import com.lago.model.Movie
import com.lago.repository.IMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: IMovieRepository
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
