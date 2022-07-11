package com.haehome.viewmodel

import com.haehome.data.model.WeatherInfo
import com.haehome.data.network.NetworkResult
import com.haehome.data.repository.WeatherRepository

class FakeWeatherRepository : WeatherRepository {
    var simulateFailure = false
    override suspend fun getRandomWeatherDetails(): NetworkResult<WeatherInfo> {
        if(simulateFailure){
            return NetworkResult.Failure("An error occurred")
        } else {
            return NetworkResult.Success(
                WeatherInfo(
                    city = "Copahaegan",
                    country = "Norway",
                    temp = 12.0,
                    description = "Mild cold and breezy"
                )
            )
        }
    }
}