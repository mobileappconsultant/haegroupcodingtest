package com.haehome.ui

import android.content.pm.ApplicationInfo
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import com.haehome.utils.openApp

@Composable
fun AppIcon(installedApp: ApplicationInfo) {
    val context = LocalContext.current
    val icon: Drawable = context.packageManager.getApplicationIcon(installedApp.packageName)
    val name: String = context.packageManager.getApplicationLabel(installedApp).toString()
    Box(contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 8.dp)){
            Card (shape = CircleShape, backgroundColor = Color.White, modifier = Modifier.size(56.dp).clickable {
                context.openApp(installedApp.packageName)
            }){
                Image(bitmap = icon.toBitmap().asImageBitmap(), contentDescription = "", modifier = Modifier.size(48.dp) )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = name, maxLines = 1, fontSize = 12.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(48.dp))
        }
    }

}
