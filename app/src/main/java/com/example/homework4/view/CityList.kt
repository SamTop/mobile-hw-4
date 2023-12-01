package com.example.homework4.view

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.homework4.viewModel.ScreenSettingsViewModel
import com.example.homework4.TemperatureUnit
import com.example.homework4.data.CityData
import com.example.homework4.data.getCities
import com.example.homework4.repository.WeatherResponse
import com.example.homework4.viewModel.CitiesViewModel

@Composable
fun CityList(
    cityName: String,
    navController: NavHostController,
    viewModel: CitiesViewModel,
    settingsViewModel: ScreenSettingsViewModel,
    context: Context
) {
    val cities = getCities(context)
    val city: CityData? = cities.find { it.name == cityName }
    val weather by viewModel.weather.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CityHeader(navController, cityName)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (city != null) {
            CityInfo(city)
        }

        if (weather != null) {
            CityWeather(weather, settingsViewModel)
        }

        BackHandler {
            navController.popBackStack()
        }
    }
}

@Composable
private fun CityWeather(
    weather: WeatherResponse?,
    settingsViewModel: ScreenSettingsViewModel
) {
    val tempCelsius = weather!!.current.temperatureCelsius
    val convertedTemp = settingsViewModel.convertTemperature(tempCelsius)
    val temperatureText = buildString {
        append("Current Temperature: ")
        append(convertedTemp)
        if (settingsViewModel.unit.value == TemperatureUnit.FAHRENHEIT) {
            append(" °F")
        } else {
            append(" °C")
        }
    }

    Text(
        text = temperatureText,
        style = TextStyle(fontSize = 20.sp),
        color = MaterialTheme.colorScheme.onSurface,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
private fun CityInfo(city: CityData) {
    val imagePainter = painterResource(id = city.image)
    Image(
        painter = imagePainter,
        contentDescription = "City Image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = city.description,
        style = TextStyle(fontSize = 16.sp),
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
private fun CityHeader(
    navController: NavHostController,
    cityName: String
) {
    IconButton(
        onClick = {
            navController.navigate("cities")
        }
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }

    Spacer(modifier = Modifier.width(30.dp))

    Text(
        text = cityName,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.primary
    )
}