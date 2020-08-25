/*
 * Copyright 2020 LagoJin LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lago.home.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.lago.model.IMovieRepository
import com.lago.model.MovieDetail
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private val repository: IMovieRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val movieId = savedStateHandle.get<Int>("movie")

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    init {
        viewModelScope.launch {
            val movieDetail = repository.getMovieDetail(movieId!!)
            _movieDetail.value = movieDetail.single()
        }
    }
}
