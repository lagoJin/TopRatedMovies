package com.lago.repository

import com.lago.api.MovieService
import com.lago.model.IMovieRepository

internal class MovieRepository(
    private val movieService: MovieService
) : IMovieRepository {


}
