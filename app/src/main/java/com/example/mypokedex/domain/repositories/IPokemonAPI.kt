package com.example.mypokedex.domain.repositories

import com.example.mypokedex.domain.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemonAPI {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>
}