package com.lago.home.di

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.AssistedInject

class HomeViewModel @AssistedInject constructor() : ViewModel() {

    @AssistedInject.Factory
    interface Factory {
        fun create(): HomeViewModel
    }
}
