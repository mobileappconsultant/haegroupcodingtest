package com.haehome.data.model

import org.json.JSONObject

data class WeatherInfo(val city: String, val country: String, val temp: Double, val description: String) {
    companion object {
        fun JSONObject.toWeatherInfo(): WeatherInfo = WeatherInfo(
            city = getString("city"),
            country = getString("country"),
            temp = getDouble("temperature"),
            description = getString("description")
        )
    }
}
