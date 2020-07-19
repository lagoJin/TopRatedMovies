package com.lago.repository

import androidx.paging.PagingSource
import com.lago.api.MovieService
import com.lago.model.Movie
import com.lago.repository.mapper.toTopRatedMovies
import retrofit2.HttpException
import java.io.IOException

private const val MOVIE_PAGE_INDEX = 1

class MoviePagingSource(
    private val movieService: MovieService
) : PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        return try {
            val position = params.key ?: MOVIE_PAGE_INDEX
            val response = movieService.getTopRatedMovies(page = position)
            val result = response.toTopRatedMovies()

            LoadResult.Page(
                data = result.results,
                prevKey = if (position == MOVIE_PAGE_INDEX) null else position - 1,
                nextKey = if (result.results.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}
