package com.example.touristicattractions.data.network

import com.example.touristicattractions.data.model.ResponseTouristPlace
import com.example.touristicattractions.data.model.TouristPlace
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(
  private val client: HttpClient = Client().httpClientAndroid
) {

  companion object {
    private const val END_POINT = "https://api-colombia.com/api/v1/TouristicAttraction"
  }

  suspend fun getTouristicPlaces(): List<TouristPlace> = client.get(END_POINT).body()

}