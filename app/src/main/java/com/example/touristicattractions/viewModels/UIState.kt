package com.example.touristicattractions.viewModels

import com.example.touristicattractions.data.model.TouristPlace

data class UIState (
  val isLoading: Boolean = false,
  val touristPlaces: List<TouristPlace> = emptyList(),
  val error: String? = null
)