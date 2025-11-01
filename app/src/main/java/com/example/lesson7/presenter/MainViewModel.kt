package com.example.lesson7.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson7.data.DogsService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainViewModel: ViewModel() {
    private val service by lazy {
        createDogService()
    }
    private val _dogImageUrl =MutableLiveData<String>()
    val dogImageUrl:LiveData<String>
        get() = _dogImageUrl

    fun loadNewDog() {
        viewModelScope.launch {
            val response = service.loadDogInfo()
            val dogInfo = response.body()

            _dogImageUrl.postValue(
                dogInfo?.url
            )
        }


        _dogImageUrl.postValue(
            "https://random.dog/2b9be14d-f084-4cbc-a266-35cc02ff62e9.gif"
        )
    }

    private fun createDogService(): DogsService =
        Retrofit.Builder()
            .baseUrl("https://random.dog/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

}