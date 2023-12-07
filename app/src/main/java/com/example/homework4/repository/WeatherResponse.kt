package com.example.homework4.repository

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName(value = "current")
    val current: Current
)

data class Current(
    @SerializedName(value = "temp_c")
    val temperatureCelsius: Double,

    @SerializedName(value = "temp_f")
    val temperatureFahrenheit: Double,
)