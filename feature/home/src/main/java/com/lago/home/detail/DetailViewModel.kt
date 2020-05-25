package com.lago.home.detail

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor() : ViewModel() {

    @AssistedInject.Factory
    interface Factory {
        fun create(): DetailViewModel
    }
}
