package com.lago.repository

import com.lago.api.MovieService
import com.lago.model.IMovieRepository
import com.lago.model.TopRatedMovies
import com.lago.repository.mapper.toTopRatedMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MovieRepository(
    private val movieService: MovieService
) : IMovieRepository {
    override fun getMoviesTopRated(): Flow<TopRatedMovies> {
        return flow {
            emit(movieService.getTopRatedMovies().toTopRatedMovies())
        }
    }
}
