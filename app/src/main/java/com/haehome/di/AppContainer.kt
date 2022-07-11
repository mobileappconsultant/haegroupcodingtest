package com.haehome.di

import com.haehome.data.network.APIConnection
import com.haehome.data.network.APIConnectionImpl
import com.haehome.data.repository.WeatherRepository
import com.haehome.data.repository.WeatherRepositoryImpl

class AppContainer {
    private val apiConnection : APIConnection = APIConnectionImpl()
    private val weatherRepository :WeatherRepository = WeatherRepositoryImpl(api = apiConnection)
    private val dispatcherProvider = DispatcherProviderImpl()
    val viewModelFactory = MainViewModelFactory(weatherRepository, dispatcherProvider)
}