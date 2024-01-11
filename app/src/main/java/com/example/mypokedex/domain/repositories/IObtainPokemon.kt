package com.example.mypokedex.domain.repositories

import com.example.mypokedex.domain.model.Pokemon

interface IObtainPokemon {
    fun obtainFromJson(pokemonName: String): Pokemon
    fun obtainListFromJson(): List<*>
    fun obtainFromApi()
}