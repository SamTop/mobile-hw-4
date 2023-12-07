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
import com.example.homework4.repository.IRepo
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

class CitiesViewModel  @Inject constructor(
    private val city: String,
    private val repo: IRepo
) : ViewModel() {
//    private val weatherRepository = DataLoaderRepository()
    private val weatherRepository = repo

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

@Singleton
class WeatherApiViewModelFactory @Inject constructor(
    private val city: String,
    private val repo: IRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CitiesViewModel::class.java)) {
            return CitiesViewModel(city, repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}