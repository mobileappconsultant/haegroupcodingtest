package com.haehome.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DarkBackgroundCard(content: @Composable () -> Unit) {
    Card(
        backgroundColor = Color.Black.copy(alpha = 0.5f),
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center){
            content()
        }
    }
}