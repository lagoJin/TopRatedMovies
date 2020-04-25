package com.lago.exchange.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideContext(
        application: Application
    ): Context = application.applicationContext
}
