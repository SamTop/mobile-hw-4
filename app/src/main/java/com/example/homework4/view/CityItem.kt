package com.example.homework4.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homework4.data.CityData

@Composable
fun CityItem(city: CityData, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("cityDetails/${city.name}")
            }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .offset(y = 40.dp)
        ) {

            val painter: Painter = painterResource(id = city.image)

            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier.size(72.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = city.name,
                style = TextStyle(fontSize = 48.sp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}