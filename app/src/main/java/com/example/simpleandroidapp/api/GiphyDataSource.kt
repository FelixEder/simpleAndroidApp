package com.example.simpleandroidapp.api

import com.example.simpleandroidapp.models.GiphyData
import com.example.simpleandroidapp.utils.Constants
import com.example.simpleandroidapp.utils.apiCall
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

/**
 * Class responsible for setting up the HTTP client and perform network requests
 */
class GiphyDataSource {
    private val apiService: GiphyApi

    init {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.GIPHY_BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        apiService = retrofit.create(GiphyApi::class.java)
    }

    suspend fun getTrendingGifs() = apiCall(
        call = { requestTrendingGifs() },
        errorMessage = "Error getting trending gifs"
    )

    private suspend fun requestTrendingGifs(): Result<GiphyData> {
        val response = apiService.getTrendingGif(
            apiKey = Constants.GIPHY_API_KEY,
            limit = 1,
            rating = "g"
        )

        if (response.isSuccessful) {
            val body = response.body()
            if (body != null)
                return Result.success(body)
        }

        return Result.failure(
            exception = IOException(
                response.errorBody()?.toString() ?: "requestTrendingGifs ${response.message()}"
            )
        )
    }
}