package com.example.touristicattractions

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


/**
 *
 */
class Client {

   val client: HttpClient = HttpClient(Android){
    install(ContentNegotiation){
      json(
        Json {
          prettyPrint = true
          isLenient = true
          ignoreUnknownKeys = true
        }
      )
    }

    install(HttpTimeout) {
      requestTimeoutMillis = 15_000L
      connectTimeoutMillis = 15_000L
      socketTimeoutMillis = 15_000L
    }

    install(Logging){
      logger = object : Logger {
        override fun log(message : String) {
          Log.v("Logger Ktor ->", message)
        }
      }

      level = LogLevel.ALL

    }

    install(DefaultRequest){
      header(HttpHeaders.ContentType, ContentType.Application.Json)
    }

    defaultRequest {
      contentType(ContentType.Application.Json)
      accept(ContentType.Application.Json)
    }

  }

}