package com.haehome.ui

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("QueryPermissionsNeeded")
@Composable
fun AppDrawerScreen() {
    val context = LocalContext.current
    val installedApps =
        context.packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
            .filter {
                context.packageManager.getLaunchIntentForPackage(it.packageName) != null && it.packageName != context.packageName
            }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(84.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        )
    ) {
        items(installedApps) { installedApp ->
            AppIcon(installedApp = installedApp)
        }
    }
}
