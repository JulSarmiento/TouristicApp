package com.example.touristicattractions.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseTouristPlace(
  val data: List<TouristPlace>
)