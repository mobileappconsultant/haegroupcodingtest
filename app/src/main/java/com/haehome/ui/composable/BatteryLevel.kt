package com.haehome.ui.composable

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.haehome.App
import com.haehome.PowerConnectionReceiver

@Composable
fun BatteryLevel() {
    Card(shape = RoundedCornerShape(16.dp)) {
        Column {
            Text(
                text = "Battery Leve"
            )
        }
    }

}