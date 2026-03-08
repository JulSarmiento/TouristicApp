package com.example.touristicattractions.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TouristPlace(
  val id: Int,
  val name: String,
  val description: String,
  val images: List<String>,
  val latitude: String,
  val longitude: String,
  val cityId: Int,
)

