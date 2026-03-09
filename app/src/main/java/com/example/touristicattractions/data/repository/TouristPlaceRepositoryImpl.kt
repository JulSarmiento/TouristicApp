package com.example.touristicattractions.data.repository

import com.example.touristicattractions.data.model.TouristPlace
import com.example.touristicattractions.data.network.ApiService
import io.ktor.client.call.body
import javax.inject.Inject

class TouristPlaceRepositoryImpl @Inject constructor(
  private val apiService: ApiService
): TouristPlaceRepository {

  override suspend fun getTouristicPlaces(): Result<List<TouristPlace>> {
    return runCatching {
      apiService.getTouristicPlaces()
    }
  }
}