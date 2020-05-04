package com.lago.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lago.model.IExchangeRepository
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @AssistedInject constructor(
    private val exchangeRepository: IExchangeRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            exchangeRepository.getExchange()
                .collect {

                }
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): HomeViewModel
    }
}
