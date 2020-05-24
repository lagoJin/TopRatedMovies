package com.lago.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lago.model.IMovieRepository
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.launch

class HomeViewModel @AssistedInject constructor(
    private val movieRepository: IMovieRepository
) : ViewModel() {

    init {
        viewModelScope.launch {

        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): HomeViewModel
    }
}
