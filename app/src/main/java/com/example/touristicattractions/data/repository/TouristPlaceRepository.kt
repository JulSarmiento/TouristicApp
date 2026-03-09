package com.example.touristicattractions.data.repository

import com.example.touristicattractions.data.model.TouristPlace

interface TouristPlaceRepository {
  suspend fun getTouristicPlaces(): Result<List<TouristPlace>>
}