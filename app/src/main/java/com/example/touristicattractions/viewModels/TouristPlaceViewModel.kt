package com.example.touristicattractions.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.touristicattractions.data.model.TouristPlace
import com.example.touristicattractions.data.repository.TouristPlaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TouristPlaceViewModel @Inject constructor(
  private val repository: TouristPlaceRepository
) : ViewModel() {

  private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState())
  val uiState: StateFlow<UIState> = _uiState.asStateFlow()

  init {
    getTouristicPlaces()
  }

  private fun getTouristicPlaces() {
    viewModelScope.launch {
      try {
        val result: Result<List<TouristPlace>> = repository.getTouristicPlaces()

        if (result.isSuccess) {
          val touristPlaces: List<TouristPlace> = result.getOrThrow()
          _uiState.value = _uiState.value.copy(
            isLoading = false,
            touristPlaces = touristPlaces,
            error = null
          )
        } else {
          val errorMessage = result.exceptionOrNull()?.message ?: "Unknown error"
          _uiState.value = _uiState.value.copy(
            isLoading = false,
            touristPlaces = emptyList(),
            error = errorMessage
          )

          Log.e("AYUUUDAAAAA", "Error fetching tourist places: $errorMessage")
        }
      } catch (e: Exception) {
        _uiState.value = _uiState.value.copy(
          isLoading = false,
          touristPlaces = emptyList(),
          error = e.message ?: "Unknown error"
        )

        Log.e("AYUUUDAAAAA", "Error fetching touristic places", e)
      }
    }
  }
}