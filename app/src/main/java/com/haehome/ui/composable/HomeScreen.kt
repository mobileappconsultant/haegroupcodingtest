package com.haehome.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haehome.App
import com.haehome.PowerConnectionReceiver
import com.haehome.data.model.WeatherInfo
import com.haehome.ui.composable.BatteryLevel
import com.haehome.ui.viewModel.MainViewModel

@Composable
fun HomeScreen(batteryLevel : Float, mainViewModel: MainViewModel, navigateToAppDrawer : () -> Unit) {
    val state by mainViewModel.weatherState.collectAsState()
    HomeBackground {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)){
                Column(horizontalAlignment = Alignment.Start) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(verticalAlignment = Alignment.Top) {
                        BatteryLevel(batteryLevel)
                        Spacer(modifier = Modifier.width(32.dp))
                        Clock()
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    when(state){
                        is MainViewModel.WeatherState.Failure -> {
                            ErrorView((state as MainViewModel.WeatherState.Failure).message) {
                                mainViewModel.getWeatherDetails()
                            }
                        }
                        MainViewModel.WeatherState.Loading -> {
                            DarkBackgroundCard {
                                CircularProgressIndicator()
                            }
                        }
                        is MainViewModel.WeatherState.Success -> {
                            WeatherWidget((state as MainViewModel.WeatherState.Success).data) {
                                mainViewModel.getWeatherDetails()
                            }
                        }
                        null -> {

                        }
                    }
                }
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                IconButton(onClick = {
                    navigateToAppDrawer()
                }) {
                    Card(backgroundColor = Color.White, shape = CircleShape) {
                        Icon(Icons.Filled.List, contentDescription = "",
                            modifier = Modifier
                                .size(48.dp)
                                .padding(4.dp),
                            tint = Color.Black
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}