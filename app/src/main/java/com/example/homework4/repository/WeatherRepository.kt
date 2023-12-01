package com.example.homework4.repository

import com.example.homework4.retrofit.RetrofitHelper
import com.example.homework4.retrofit.WeatherAPIService

class DataLoaderRepository {
    suspend fun loadWeather(q: String, apiKey: String): WeatherResponse {
        val apiService = RetrofitHelper.getRetrofit().create(WeatherAPIService::class.java)
        return apiService.getWeather(
            q,
            apiKey
        )
    }


}