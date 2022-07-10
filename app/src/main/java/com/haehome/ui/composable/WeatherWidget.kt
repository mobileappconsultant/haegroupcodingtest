package com.haehome.ui.composable

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haehome.data.model.WeatherInfo

@Composable
fun WeatherWidget(weatherInfo: WeatherInfo, onRefresh : () -> Unit) {
    DarkBackgroundCard {
        Column(
            Modifier
                .fillMaxWidth()) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Weather Info", fontSize = 14.sp, color = Color.White)
                Spacer( modifier = Modifier.weight(1f))
                IconButton(onClick = onRefresh) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(24.dp), tint = Color.White)

                }
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Text(text = "${weatherInfo.temp.toString()} \u2103", fontSize = 32.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column {
                    Text(text = weatherInfo.country, fontSize = 32.sp, color = Color.White)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = weatherInfo.city, fontSize = 20.sp, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = weatherInfo.description, fontSize = 16.sp, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }
    }

}