package com.valentinerutto.architecturetemplate.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valentinerutto.architecturetemplate.data.DogImage
import com.valentinerutto.architecturetemplate.data.DogImageRepository
import com.valentinerutto.architecturetemplate.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DogImageViewModel(private val dogImageRepository: DogImageRepository) : ViewModel() {

    private val _imageResponse = MutableLiveData<DogImage>()
    val imageResponse: LiveData<DogImage>
        get() = _imageResponse

    //used in compose ui
    private val _image = MutableStateFlow(DogImage(""))
    val image = _image.asStateFlow()

    private suspend fun getImage() {
        when (val response = dogImageRepository.getDogImage()) {

            is Resource.Error -> {
                TODO()
            }

            is Resource.Success -> {
                _imageResponse.postValue(response.data!!)
                _image.value = response.data
            }
        }

    }

    fun fetchImage() {
        viewModelScope.launch {
            getImage()
        }
    }


}