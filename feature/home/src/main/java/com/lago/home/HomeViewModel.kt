package com.lago.home

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.lago.model.Movie
import com.lago.repository.IMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: IMovieRepository
) : ViewModel() {

    fun searchRepo(): Flow<PagingData<Movie>> {
        return movieRepository.getMovies()
    }
}
