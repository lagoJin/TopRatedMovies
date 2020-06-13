package com.lago.exchange

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ExchangeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BuildType.init()
    }
}
