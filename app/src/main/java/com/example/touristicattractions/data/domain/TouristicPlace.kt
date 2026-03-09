package com.example.touristicattractions.data.domain

data class TouristicPlace(
    val id: Int,
    val name: String,
    val description: String,
    val images: List<String>,
    val latitude: String,
    val longitude: String,
    val cityId: Int
)
