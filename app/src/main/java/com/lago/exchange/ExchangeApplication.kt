package com.lago.exchange

import com.lago.exchange.di.createAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ExchangeApplication : DaggerApplication() {

    private val applicationComponent by lazy {
        createAppComponent()
    }

    override fun onCreate() {
        super.onCreate()
        BuildType.init()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationComponent
    }
}
