package com.example.layoutmusicapp.viewmodel

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import com.example.layoutmusicapp.activity
import com.example.layoutmusicapp.context
import com.example.layoutmusicapp.ui.navigation.NavigationItem
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationServices
import java.security.Permission
import java.util.jar.Manifest

class LocationViewModel: ViewModel() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    fun getCurrentLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity)
        checkLocationPermission()
    }

    private fun checkLocationPermission() {
        Toast.makeText(activity, "1", Toast.LENGTH_SHORT).show()

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(activity, "2", Toast.LENGTH_SHORT).show()
            val permission = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
            ActivityCompat.requestPermissions(activity, permission, 0)
            return
        } else {
            Toast.makeText(activity, "3", Toast.LENGTH_SHORT).show()
            val task = fusedLocationProviderClient.lastLocation

            task.addOnSuccessListener {
                if (it != null) {
                    Log.i(TAG, "Current location: Широта - ${it.latitude}, Долгота - ${it.longitude}")
                    Log.i(TAG, "Current location: Скорость - ${it.speed}")
                }
            }
        }
    }
}