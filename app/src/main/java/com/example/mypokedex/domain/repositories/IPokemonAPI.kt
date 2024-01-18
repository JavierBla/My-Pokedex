package com.example.mypokedex.domain.repositories

import com.example.mypokedex.domain.model.Pokemon
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.File

interface IPokemonAPI {
    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Call<JsonObject>
}