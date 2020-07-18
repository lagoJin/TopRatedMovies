package com.lago.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lago.api.MovieService
import com.lago.api.response.MovieResponse
import com.lago.model.IMovieRepository
import com.lago.model.Movie
import com.lago.model.MovieDetail
import com.lago.model.TopRatedMovies
import com.lago.repository.mapper.toMovieDetail
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

    override fun getMovieDetail(movieId: Int): Flow<MovieDetail> {
        return flow { emit(movieService.getMovieDetail(movieId = movieId).toMovieDetail()) }
    }

    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 113,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(movieService) }
        ).flow
    }
}
