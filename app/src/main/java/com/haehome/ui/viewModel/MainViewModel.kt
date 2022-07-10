package com.haehome.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haehome.data.model.WeatherInfo
import com.haehome.data.network.HttpConnection
import com.haehome.data.network.NetworkResult
import com.haehome.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val httpConnection: HttpConnection) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherState?>(null)
    val weatherState = _weatherState.asStateFlow()

    init {
        getWeatherDetails()
    }
    fun getWeatherDetails() {
        viewModelScope.launch() {
            withContext(Dispatchers.IO){
                _weatherState.value = WeatherState.Loading
                when(val result = httpConnection.performHttpConnection(Constants.weatherCities.random())){
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