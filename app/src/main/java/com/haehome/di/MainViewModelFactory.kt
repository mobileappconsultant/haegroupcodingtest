package com.haehome.di

import com.haehome.data.repository.WeatherRepository
import com.haehome.ui.viewModel.MainViewModel

class MainViewModelFactory(private val weatherRepository: WeatherRepository, private val dispatcherProvider: DispatcherProvider) :
    Factory<MainViewModel> {
    override fun create(): MainViewModel {
        return MainViewModel(weatherRepository, dispatcherProvider)
    }
}

interface Factory<T> {
    fun create(): T
}
