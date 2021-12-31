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

package com.lago.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.lago.core.util.Event
import com.lago.model.IMovieRepository
import com.lago.model.Movie
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
