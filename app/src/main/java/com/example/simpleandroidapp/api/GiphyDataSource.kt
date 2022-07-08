package com.example.simpleandroidapp.api

import com.example.simpleandroidapp.models.GiphyData
import com.example.simpleandroidapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class GiphyDataSource {
    private lateinit var apiService: GiphyApi

    private fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.GIPHY_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        apiService = retrofit.create(GiphyApi::class.java)
    }

    suspend fun requestTrendingGifs(): Result<GiphyData> {
        setupRetrofit()

        val response = apiService.getTrendingGif(Constants.GIPHY_API_KEY)

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