package com.haehome.utils

import android.content.Context
import androidx.core.content.ContextCompat


fun Context.openApp(packageName: String) {
    val launchIntent = packageManager.getLaunchIntentForPackage(packageName)
    startActivity(launchIntent)
}