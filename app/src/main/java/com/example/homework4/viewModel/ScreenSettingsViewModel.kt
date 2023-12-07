package com.example.homework4.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework4.TemperatureUnit

class ScreenSettingsViewModel : ViewModel() {
    private val _unit = MutableLiveData<TemperatureUnit>()
    val unit: LiveData<TemperatureUnit> get() = _unit

    init {
        _unit.value = TemperatureUnit.CELSIUS
    }

    fun setTemperatureUnit(unit: TemperatureUnit) {
        _unit.value = unit
    }

    fun convertTemperature(value: Double): Double {
        return when (_unit.value) {
            TemperatureUnit.CELSIUS -> value
            TemperatureUnit.FAHRENHEIT -> (value * 9 / 5) + 32
            else -> {0.0}
        }
    }
}