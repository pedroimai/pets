package com.pedroimai.pets.networking

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breed(
    @Json(name = "id") var id: String,
    @Json(name="name") var name: String
)