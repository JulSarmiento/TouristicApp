package com.example.touristicattractions.ui.components


import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.touristicattractions.data.model.TouristPlace

@Composable
fun TouristicPlaces(
  touristicPlaces: List<TouristPlace>,
  modifier: Modifier = Modifier
) {
  LazyColumn(
    modifier = modifier
  ) {
    items(touristicPlaces.size) { index ->
      TouristicPlace(touristicPlaces[index])
    }
  }

  Log.d("TouristicPlaces", "Drugstores: $touristicPlaces")
}