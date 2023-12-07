package com.example.homework4.repository

import javax.inject.Inject

interface IRepo {
    suspend fun loadWeather(q: String, apiKey: String): WeatherResponse
}
