package com.haehome.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haehome.PowerConnectionReceiver
import com.haehome.ui.composable.BatteryLevel

@Composable
fun HomeScreen(navigateToAppDrawer : () -> Unit) {
    Box {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(32.dp))
                    BatteryLevel()

                }
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                IconButton(onClick = {
                    navigateToAppDrawer()
                }) {
                    Icon(Icons.Filled.List, contentDescription = "",
                        Modifier
                            .size(48.dp)
                            .padding(4.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}