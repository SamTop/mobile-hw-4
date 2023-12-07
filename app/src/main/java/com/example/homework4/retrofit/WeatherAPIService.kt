package com.example.homework4.retrofit

import com.example.homework4.repository.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {
    @GET("current.json")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("key") apiKey: String
    ): WeatherResponse
}
