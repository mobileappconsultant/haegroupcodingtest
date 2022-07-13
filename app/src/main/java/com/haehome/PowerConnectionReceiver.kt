package com.haehome

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PowerConnectionReceiver : BroadcastReceiver() {
    companion object {
        var batteryLevel by mutableStateOf(-1f)
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == BatteryManager.ACTION_CHARGING || intent?.action == BatteryManager.ACTION_DISCHARGING) {
        }
        val batteryPct: Float? = intent?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        }
        batteryLevel = batteryPct ?: -1f
    }
}
