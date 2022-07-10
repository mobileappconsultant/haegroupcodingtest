package com.haehome.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.haehome.R

@Composable
fun HomeBackground(content: @Composable () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.bg_image), contentDescription = "Background Image", contentScale = ContentScale.FillBounds)
        content()
    }
}