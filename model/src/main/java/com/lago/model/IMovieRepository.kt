package com.lago.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getMoviesTopRated(): Flow<TopRatedMovies>

    fun getMovies(): Flow<PagingData<Movie>>

    fun getMovieDetail(movieId: Int): Flow<MovieDetail>
}
