package com.lago.exchange.di

import androidx.fragment.app.FragmentActivity
import com.lago.core.scope.FragmentScope
import com.lago.exchange.MainActivity
import com.lago.home.HomeFragment
import com.lago.home.di.DetailFragmentModule
import com.lago.home.di.HomeAssistedInjectModule
import com.lago.home.di.HomeFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @Binds
    fun providesActivity(mainActivity: MainActivity): FragmentActivity

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentModule::class,
            DetailFragmentModule::class,
            HomeAssistedInjectModule::class]
    )
    fun bindHomeFragment(): HomeFragment

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
