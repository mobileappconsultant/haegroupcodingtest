package com.haehome.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

fun Context.openApp(packageName: String) {
    val launchIntent = packageManager.getLaunchIntentForPackage(packageName)
    startActivity(launchIntent)
}

fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("HH:mm")
    val cal: Calendar = Calendar.getInstance()
    return sdf.format(cal.time)
}
