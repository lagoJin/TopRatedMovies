package com.lago.api

import com.lago.api.response.MovieDetailResponse
import com.lago.api.response.TopRatedMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Locale

interface MovieService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = Key.KEY,
        @Query("language") language: String = Locale.getDefault().language,
        @Query("page") page: Int = 1,
        @Query("region") region: String = Locale.getDefault().country.uppercase(Locale.getDefault())
    ): TopRatedMoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Key.KEY,
        @Query("language") language: String = Locale.getDefault().language
    ): MovieDetailResponse
}
