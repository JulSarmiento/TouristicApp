package com.example.touristicattractions.viewModels

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.touristicattractions.utils.Location
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Locale
import javax.inject.Inject

class LocationViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {

    private val _location = MutableStateFlow<Location?>(null)
    val location: StateFlow<Location?> = _location

    init {
        _location.value = Location(lat =-27.11944 , longi = -109.35742)
    }

    fun hasPermissions() : Boolean {
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        val hasFineLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        return hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED && hasFineLocationPermission == PackageManager.PERMISSION_GRANTED
    }

    fun getLocation(latitude: Double, longitude: Double): List<Address?>? {
        return geocoder.getFromLocation(latitude, longitude, 1)
    }

    fun getUserLocation() {

    }

    private val geocoder = Geocoder(context, Locale.getDefault())

}