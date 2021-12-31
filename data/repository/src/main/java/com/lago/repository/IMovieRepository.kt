package com.lago.repository

import androidx.paging.PagingData
import com.lago.model.Movie
import com.lago.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getMovies(): Flow<PagingData<Movie>>

    fun getMovieDetail(movieId: Int): Flow<MovieDetail>
}
