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
