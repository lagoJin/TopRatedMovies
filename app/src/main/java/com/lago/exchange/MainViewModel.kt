package com.lago.exchange

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.AssistedInject

class MainViewModel @AssistedInject constructor() : ViewModel() {

    @AssistedInject.Factory
    interface Factory {
        fun create(): MainViewModel
    }
}
