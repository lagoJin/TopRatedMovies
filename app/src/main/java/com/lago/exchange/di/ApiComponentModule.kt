package com.lago.exchange.di

import android.app.Application
import com.lago.api.ApiComponent
import com.lago.api.ExchangeService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ApiComponentModule {

    @Singleton
    @Provides
    fun provideExchangeApi(
        application: Application
    ): ExchangeService {
        return ApiComponent.factory()
            .create(application)
            .exchangeApi()
    }
}
