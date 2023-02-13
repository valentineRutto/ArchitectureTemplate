package com.valentinerutto.architecturetemplate.api

import com.valentinerutto.architecturetemplate.data.DogImageResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/breeds/image/random")
    suspend fun getRandomDogImage():Response<DogImageResponse>
}