package com.haehome.data.network

import com.haehome.data.model.WeatherInfo

interface APIConnection  {
    suspend fun getWeatherDetails(httpUrl : String) : NetworkResult<WeatherInfo>
}