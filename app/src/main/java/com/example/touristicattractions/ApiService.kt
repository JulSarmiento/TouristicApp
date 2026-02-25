package com.example.touristicattractions

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(
  private val client: HttpClient
) {

  companion object {
    private const val END_POINT = "https://api-colombia.com/api/v1/TouristicAttraction"
  }

  suspend fun getTouristicPlaces() {
    client.get(END_POINT)
  }

}