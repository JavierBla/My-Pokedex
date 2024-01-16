package com.example.mypokedex.domain.repositories

import com.example.mypokedex.domain.model.Pokemon
import retrofit2.Response

interface IObtainPokemon {
    fun obtainFromJson(pokemonName: String): Pokemon
    fun obtainListFromJson(): List<*>
    fun obtainFromApi(): Pokemon?
}