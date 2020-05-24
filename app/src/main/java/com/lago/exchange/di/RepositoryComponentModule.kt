package com.lago.exchange.di

import android.content.Context
import com.lago.api.MovieService
import com.lago.model.IMovieRepository
import com.lago.repository.RepositoryComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryComponentModule {

    @Singleton
    @Provides
    fun provideExchangeRepository(
        repositoryComponent: RepositoryComponent
    ): IMovieRepository {
        return repositoryComponent.exchangeRepository()
    }

    @Singleton
    @Provides
    fun provideRepositoryComponent(
        context: Context,
        movieService: MovieService
    ): RepositoryComponent {
        return RepositoryComponent.factory().create(
            context, movieService
        )
    }
}
