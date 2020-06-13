package com.lago.home.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lago.model.IMovieRepository
import com.lago.model.MovieDetail
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private val repository: IMovieRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    fun initMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _movieDetail.value = repository.getMovieDetail(movieId).single()
        }
    }
}
