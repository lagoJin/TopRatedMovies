package com.lago.home.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lago.model.IMovieRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(
    @Assisted val movieId: Int,
    repository: IMovieRepository
) : ViewModel() {

    val movieDetail = repository.getMovieDetail(movieId).asLiveData(viewModelScope.coroutineContext)

    init {
        repository.getMovieDetail(movieId)
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(movieId: Int): DetailViewModel
    }
}
