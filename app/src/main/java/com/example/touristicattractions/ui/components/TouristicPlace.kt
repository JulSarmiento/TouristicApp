package com.example.touristicattractions.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.touristicattractions.data.model.TouristPlace

@Composable
fun TouristicPlace(
  touristicPlace: TouristPlace,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Text(text = touristicPlace.name)
    Text(text = "${touristicPlace.cityId}")
  }
}