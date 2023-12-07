package com.example.homework4.data

import android.content.Context
import com.example.homework4.R


data class CityData(
    val name: String,
    val description: String,
    val image: Int,
)

fun getCities(context: Context): ArrayList<CityData> {
    return arrayListOf(
        CityData(
            context.resources.getString(R.string.city1_name),
            context.resources.getString(R.string.city1_description),
            R.drawable.city1
        ),
        CityData(
            context.resources.getString(R.string.city2_name),
            context.resources.getString(R.string.city2_description),
            R.drawable.city2
        ),
        CityData(
            context.resources.getString(R.string.city3_name),
            context.resources.getString(R.string.city3_description),
            R.drawable.city3
        ),
        CityData(
            context.resources.getString(R.string.city4_name),
            context.resources.getString(R.string.city4_description),
            R.drawable.city4
        ),
    )
}
