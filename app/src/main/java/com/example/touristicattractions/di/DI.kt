package com.example.touristicattractions.di

import android.content.Context
import com.example.touristicattractions.data.network.ApiService
import com.example.touristicattractions.data.network.Client
import com.example.touristicattractions.data.repository.TouristPlaceRepository
import com.example.touristicattractions.data.repository.TouristPlaceRepositoryImpl
import com.example.touristicattractions.viewModels.LocationViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideHttpClient(): HttpClient {
        return Client().httpClientAndroid
    }

    @Provides
    fun provideApiService(client: HttpClient): ApiService {
        return ApiService(client)
    }

    @Provides
    fun provideTouristicPlace( apiService: ApiService) : TouristPlaceRepository {
        return TouristPlaceRepositoryImpl(apiService)
    }

    @Provides
    @ApplicationContext
    fun provideContext( @ApplicationContext context: Context): Context = context

    @Provides
    fun providesLocationViewModel(
        @ApplicationContext context: Context
    ): LocationViewModel = LocationViewModel(
        context
    )
}