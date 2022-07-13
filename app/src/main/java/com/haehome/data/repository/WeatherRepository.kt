package com.haehome.data.repository

import com.haehome.data.model.WeatherInfo
import com.haehome.data.network.NetworkResult

interface WeatherRepository {
    suspend fun getRandomWeatherDetails(): NetworkResult<WeatherInfo>
}
