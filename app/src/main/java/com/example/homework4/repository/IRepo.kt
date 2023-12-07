package com.example.homework4.repository

interface IRepo {
    suspend fun loadWeather(q: String, apiKey: String): WeatherResponse
}
