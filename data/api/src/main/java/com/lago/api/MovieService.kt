package com.lago.api

import com.lago.api.response.TopRatedMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "f539004fcc50772bbe9e950719441ef5",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): TopRatedMoviesResponse

}
