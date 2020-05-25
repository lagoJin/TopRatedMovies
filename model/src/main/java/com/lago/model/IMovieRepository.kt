package com.lago.model

import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getMoviesTopRated(): Flow<TopRatedMovies>
}
