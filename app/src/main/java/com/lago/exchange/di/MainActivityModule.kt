package com.lago.exchange.di

import androidx.fragment.app.FragmentActivity
import com.lago.exchange.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @Binds
    fun providesActivity(mainActivity: MainActivity): FragmentActivity

    @Module
    abstract class MainActivityBuilder {

        @ContributesAndroidInjector(
            modules = [
                MainActivityModule::class
            ]
        )
        abstract fun contributeMainActivity(): MainActivity
    }
}
