package com.haehome.ui.composable

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haehome.App
import com.haehome.PowerConnectionReceiver

@Composable
fun BatteryLevel(batteryLevel: Float) {
    Card(shape = RoundedCornerShape(16.dp), backgroundColor = Color.Transparent) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "Battery Level",
                color = Color.White
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(verticalAlignment = Alignment.Top) {
                Card(
                    shape = RoundedCornerShape(12.dp), modifier = Modifier
                        .rotate(270f)
                        .width(72.dp)
                ) {
                    LinearProgressIndicator(
                        progress = batteryLevel.div(100), modifier = Modifier
                            .width(52.dp)
                            .height(32.dp),
                        color = Color.Green
                    )
                }

                Text(
                    text = "${batteryLevel.toInt()}%",
                    color = Color.White,
                    fontSize = 32.sp,
                    modifier = Modifier.offset(y = -24.dp)
                )
            }
        }
    }

}