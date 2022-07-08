package com.example.simpleandroidapp.api

import com.example.simpleandroidapp.models.GiphyData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {

    @GET("/v1/gifs/trending/api_key")
    suspend fun getTrendingGif(
        @Query("api_key") apiKey: String
    ): Response<GiphyData>

}