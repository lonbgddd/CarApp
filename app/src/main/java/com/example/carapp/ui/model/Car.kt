package com.example.carapp.ui.model

import com.google.gson.annotations.SerializedName

// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json = Json { allowStructuredMapKeys = true }
// val car  = json.parse(Car.serializer(), jsonString)

typealias Car = List<CarElement>

data class CarElement(
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("avatar")
    val avatar: String? = null,
    @SerializedName("id")
    val id: String? = null
)
