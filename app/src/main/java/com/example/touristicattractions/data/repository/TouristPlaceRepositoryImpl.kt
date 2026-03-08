package com.example.touristicattractions.data.repository

import com.example.touristicattractions.data.model.TouristPlace
import com.example.touristicattractions.data.network.ApiService


class TouristPlaceRepositoryImpl(
  private val apiService: ApiService = ApiService()
): TouristPlaceRepository {

  override suspend fun getTouristicPlaces(): Result<List<TouristPlace>> {
    return runCatching {
      apiService.getTouristicPlaces()

    }
  }
}