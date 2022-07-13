package com.haehome.data.repository

import com.haehome.data.model.WeatherInfo
import com.haehome.data.network.APIConnection
import com.haehome.data.network.NetworkResult
import com.haehome.utils.Constants

class WeatherRepositoryImpl(private val api: APIConnection) : WeatherRepository {
    override suspend fun getRandomWeatherDetails(): NetworkResult<WeatherInfo> = api.getWeatherDetails(Constants.weatherCities.random())
}
