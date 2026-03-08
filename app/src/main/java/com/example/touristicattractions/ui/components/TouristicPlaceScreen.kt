package com.example.touristicattractions.ui.components


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.touristicattractions.viewModels.TouristPlaceViewModel

@Composable
fun TouristPlaceScreen(
  modifier: Modifier = Modifier,
  viewModel: TouristPlaceViewModel = viewModel()
) {
  val uiState = viewModel.uiState.collectAsState()

  TouristicPlaces(
    touristicPlaces = uiState.value.touristPlaces,
    modifier = modifier
  )


}