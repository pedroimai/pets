package com.pedroimai.pets.listing

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pedroimai.pets.networking.Breed
import com.pedroimai.pets.networking.DogService
import kotlinx.coroutines.ExperimentalCoroutinesApi

class ListingViewModel @ViewModelInject constructor(private val api: DogService) : ViewModel() {
    @ExperimentalCoroutinesApi
    suspend fun getBreeds(): LiveData<List<Breed>> =
        api.getBreeds().asLiveData()
}