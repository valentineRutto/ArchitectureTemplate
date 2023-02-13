package com.valentinerutto.architecturetemplate.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valentinerutto.architecturetemplate.data.DogImage
import com.valentinerutto.architecturetemplate.data.DogImageRepository
import com.valentinerutto.architecturetemplate.utils.Resource
import kotlinx.coroutines.launch

class DogImageViewModel(private val dogImageRepository: DogImageRepository): ViewModel() {

    private val _imageResponse = MutableLiveData<DogImage>()
    val imageResponse :LiveData<DogImage>
    get()= _imageResponse

    private     suspend fun getImage(){
        when(val response = dogImageRepository.getDogImage()){
            is Resource.Error -> {
                TODO()
            }
            is Resource.Success -> {
_imageResponse.postValue(response.data!!)            }
        }

    }

    fun fetchImage(){
        viewModelScope.launch {
            getImage()
        }
    }


}