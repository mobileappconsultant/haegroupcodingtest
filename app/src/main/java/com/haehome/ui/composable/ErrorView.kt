package com.haehome.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorView(message: String, onRetry: () -> Unit) {
    DarkBackgroundCard {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = message, fontSize = 16.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = onRetry) {
                Text(text = "Retry")
            }
        }
    }
}
