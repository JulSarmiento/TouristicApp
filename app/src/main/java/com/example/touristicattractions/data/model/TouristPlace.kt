package com.example.touristicattractions.data.model

import com.example.touristicattractions.data.domain.TouristicPlace
import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
data class TouristPlace(
  val id: Int,
  val name: String,
  val description: String,
  val images: List<String>,
  val latitude: String,
  val longitude: String,
  val cityId: Int,
) {

}

fun TouristPlace.toTouristicPlace(): TouristicPlace = TouristicPlace(
  id = this.id,
  name = this.name,
  description = this.description,
  images = this.images,
  latitude = this.latitude,
  longitude = this.longitude,
  cityId = this.cityId
)

