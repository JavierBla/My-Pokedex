package com.example.mypokedex.domain.repositories

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemonAPI {
    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Call<JsonObject>
}