package com.lago.model

data class TopRatedMovies(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<Movie>
)

data class Movie(
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean,
    val posterPath: String,
    val id: Int,
    val adult: Boolean,
    val backdropPath: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val title: String,
    val voteAverage: Double,
    val overView: String,
    val releaseDate: String
)
