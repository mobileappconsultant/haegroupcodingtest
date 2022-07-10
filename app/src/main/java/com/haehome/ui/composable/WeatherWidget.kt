package com.haehome.ui.composable

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haehome.data.model.WeatherInfo

@Composable
fun WeatherWidget(weatherInfo: WeatherInfo) {
    Column(Modifier.padding(32.dp)) {
        Row {
            Box(modifier = Modifier.padding(16.dp)) {
                Text(text = "${weatherInfo.temp.toString()}\u2103", fontSize = 32.sp, color = Color.White)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = weatherInfo.country, fontSize = 32.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = weatherInfo.city, fontSize = 24.sp, color = Color.White)
            }
        }
        Text(text = weatherInfo.description, fontSize = 14.sp, color = Color.White)
    }
}