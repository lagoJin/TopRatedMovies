package com.lago.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lago.api.MovieService
import com.lago.model.Movie
import com.lago.model.MovieDetail
import com.lago.repository.mapper.toMovieDetail
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository @Inject constructor(
    private val movieService: MovieService
) : IMovieRepository {

    override fun getMovieDetail(movieId: Int): Flow<MovieDetail> {
        return flow { emit(movieService.getMovieDetail(movieId = movieId).toMovieDetail()) }
    }

    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 113,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { MoviePagingSource(movieService) }
        ).flow
    }
}
