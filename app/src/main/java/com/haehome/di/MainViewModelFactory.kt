package com.haehome.di

import com.haehome.data.repository.WeatherRepository
import com.haehome.ui.viewModel.MainViewModel

class MainViewModelFactory(private val weatherRepository: WeatherRepository) :
    Factory<MainViewModel> {
    override fun create(): MainViewModel {
        return MainViewModel(weatherRepository)
    }
}

interface Factory<T> {
    fun create(): T
}