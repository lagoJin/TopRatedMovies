package com.lago.model

import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getMoviesTopRated(): Flow<TopRatedMovies>

    fun getMovieDetail(movieId: Int): Flow<MovieDetail>
}
