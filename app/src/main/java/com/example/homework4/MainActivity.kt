package com.example.homework4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.homework4.navigation.NavGraph
import com.example.homework4.repository.DataLoaderRepository
import com.example.homework4.repository.IRepo
import com.example.homework4.repository.WeatherResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var repo : DataLoaderRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Homework4()
        }
    }

    @Composable
    fun Homework4() {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            NavGraph(LocalContext.current, repo)
        }
    }
}

interface WeatherService {
    @GET("current.json")
    suspend fun getWeather(@Query("q") city: String): WeatherResponse
}

enum class TemperatureUnit {
    CELSIUS, FAHRENHEIT
}
