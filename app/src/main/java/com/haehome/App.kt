package com.haehome

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.haehome.di.AppContainer

class App : Application() {

    companion object {
        var batteryPercent by mutableStateOf<Float?>(0f)
    }

    val appContainer = AppContainer()

    override fun onCreate() {
        super.onCreate()
        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val batteryPct: Float? = intent?.let { intent ->
                    val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                    level * 100 / scale.toFloat()
                }
                batteryPercent = batteryPct
            }
        }, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }
}