package com.example.homework4.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.homework4.repository.IRepo
import com.example.homework4.view.CityList
import com.example.homework4.viewModel.CitiesViewModel
import com.example.homework4.view.WelcomeScreen
import com.example.homework4.viewModel.ScreenSettingsViewModel
import com.example.homework4.view.CitiesScreen
import com.example.homework4.view.SettingsScreen
import com.example.homework4.viewModel.WeatherApiViewModelFactory

@Composable
fun NavGraph(context: Context, repo: IRepo) {
    val navController = rememberNavController()

    val settingsViewModel: ScreenSettingsViewModel = viewModel()

    NavHost(navController = navController, startDestination = Route.AppStartNav.route) {
        navigation(
            route = Route.AppStartNav.route,
            startDestination = Route.Welcome.route
        ) {
            composable(route = Route.Welcome.route) {
                WelcomeScreen(navController, settingsViewModel, repo)
            }
            composable(route = Route.Cities.route) {
                CitiesScreen(navController, context)
            }
            composable(route = Route.Settings.route) {
                SettingsScreen(navController, settingsViewModel)
            }
            composable(route = Route.CityDetails.route) {
                    backStackEntry ->
                val city = backStackEntry.arguments?.getString("city")
                val viewModelFactory = WeatherApiViewModelFactory(city = city.toString(), repo)
                val viewModel = ViewModelProvider(ViewModelStore(), viewModelFactory)[CitiesViewModel::class.java]
                if (city != null) {
                    CityList(cityName = city, navController, viewModel, settingsViewModel, context)
                }
            }
        }
    }
}
