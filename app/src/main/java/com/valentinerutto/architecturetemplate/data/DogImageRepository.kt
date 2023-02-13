package com.valentinerutto.architecturetemplate.data

import com.valentinerutto.architecturetemplate.api.ApiService
import com.valentinerutto.architecturetemplate.utils.Resource

class DogImageRepository(private val apiService: ApiService) {

suspend fun getDogImage():Resource<DogImage>{

    val response = apiService.getRandomDogImage()

    if (!response.isSuccessful) return Resource.Error(errorMessage = response.message())

    val dogImageEntity = mapResponseToEntity(response.body())

    return Resource.Success(data = dogImageEntity)

}
    private fun mapResponseToEntity(dogImageResponse: DogImageResponse?): DogImage{
        return DogImage(
          url=  dogImageResponse?.message
        )
    }

}