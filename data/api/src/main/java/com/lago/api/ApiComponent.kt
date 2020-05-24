package com.lago.api

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun exchangeApi(): MovieService

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApiComponent
    }

    companion object {
        fun factory(): Factory = DaggerApiComponent.factory()
    }
}
