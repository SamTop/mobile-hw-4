package com.example.homework4.repository

import com.example.homework4.retrofit.RetrofitHelper
import com.example.homework4.retrofit.WeatherAPIService
import retrofit2.HttpException
import javax.inject.Inject

class DataLoaderRepository @Inject constructor() : IRepo {
    override suspend fun loadWeather(q: String, apiKey: String): WeatherResponse {
        val apiService = RetrofitHelper.getRetrofit().create(WeatherAPIService::class.java)
        return apiService.getWeather(
            q,
            apiKey
        )
    }

}
