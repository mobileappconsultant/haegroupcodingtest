package com.haehome.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haehome.data.model.WeatherInfo
import com.haehome.data.network.NetworkResult
import com.haehome.data.repository.WeatherRepository
import com.haehome.di.DispatcherProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val weatherRepository: WeatherRepository, private val dispatcherProvider: DispatcherProvider) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherState?>(null)
    val weatherState = _weatherState.asStateFlow()

    init {
        getWeatherDetails()
    }
    fun getWeatherDetails() {
        viewModelScope.launch() {
            withContext(dispatcherProvider.io){
                _weatherState.value = WeatherState.Loading
                when(val result = weatherRepository.getRandomWeatherDetails()){
                    is NetworkResult.Failure -> {
                        _weatherState.value = WeatherState.Failure(result.message)
                    }
                    is NetworkResult.Success -> {
                        _weatherState.value = WeatherState.Success(result.data)
                    }
                }
            }
        }
    }

    sealed class WeatherState {
        object Loading : WeatherState()
        data class Success(val data: WeatherInfo) : WeatherState()
        data class Failure(val message: String) : WeatherState()
    }
}