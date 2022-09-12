package com.example.layoutmusicapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.layoutmusicapp.activity
import com.example.layoutmusicapp.viewmodel.LocationViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


@Composable
fun LocationScreen(locationViewModel: LocationViewModel = viewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { locationViewModel.getCurrentLocation() }
        ) {
            Text("Получить текущее местоположение")
        }
    }
}