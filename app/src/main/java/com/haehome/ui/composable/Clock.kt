package com.haehome.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haehome.utils.getCurrentTime
import kotlinx.coroutines.delay
import java.util.Date

@Composable
fun Clock() {
    var currentTime by remember {
        mutableStateOf(getCurrentTime())
    }
    LaunchedEffect(Unit){
        while (true) {
            currentTime = getCurrentTime()
            delay(1000)
        }
    }

    Column(
        Modifier
            .padding(16.dp)
        .background(Color.Transparent), verticalArrangement = Arrangement.SpaceAround) {
        Text(text = "Clock", color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = currentTime, fontSize = 32.sp, color = Color.White)

    }
}