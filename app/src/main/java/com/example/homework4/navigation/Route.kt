package com.example.homework4.navigation

sealed class Route(
    val route: String,
) {
    object Welcome : Route(route = "welcome") // screen1
    object Cities : Route(route = "cities") // cities
    object CityDetails : Route(route = "cityDetails/{city}") // cityDetails
    object Settings : Route(route = "settings") // settings
    object AppStartNav : Route(route = "appStartNav")
}
