package com.pedroimai.pets.networking

import android.util.Log
import com.github.kittinunf.fuel.core.awaitResult
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

const val DOGS_API_ALL_BREEDS = "https://api.thedogapi.com/v1/breeds"

class DogService @Inject constructor() {
    @ExperimentalCoroutinesApi
    suspend fun getBreeds() = flow<List<Breed>> {
        //todo: find a better way to deserialize list
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, Breed::class.java)
        val adapter: JsonAdapter<List<Breed>> = moshi.adapter(listType)

        emit(DOGS_API_ALL_BREEDS.httpGet()
            .awaitResult(moshiDeserializerOf(adapter)).get())
    }
        .catch { Log.d("DogService", "getBreeds Exception: ${it.message}") }
        .flowOn((Dispatchers.IO))
}