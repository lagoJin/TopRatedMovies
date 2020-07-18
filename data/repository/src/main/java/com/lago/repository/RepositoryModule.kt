package com.lago.repository

import com.lago.api.MovieService
import com.lago.model.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    fun movieRepository(
        movieService: MovieService
    ): IMovieRepository {
        return MovieRepository(movieService)
    }
}
