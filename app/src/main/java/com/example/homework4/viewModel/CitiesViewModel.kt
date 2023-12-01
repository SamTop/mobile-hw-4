package com.example.homework4.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.homework4.repository.DataLoaderRepository
import com.example.homework4.repository.WeatherResponse
import com.example.homework4.data.API_KEY
import kotlinx.coroutines.launch

class CitiesViewModel(private val city: String) : ViewModel() {
    private val weatherRepository = DataLoaderRepository()

    private val _weather = MutableLiveData<WeatherResponse>()
    val weather: LiveData<WeatherResponse> get() = _weather

    init {
        viewModelScope.launch {
            try {
                val response = weatherRepository.loadWeather(city, API_KEY)
                _weather.value = response
            } catch (e: Exception) {
                Log.e("Retrofit", "Error fetching user data", e)
            }
        }
    }
}

class WeatherApiViewModelFactory(private val city: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CitiesViewModel::class.java)) {
            return CitiesViewModel(city) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}