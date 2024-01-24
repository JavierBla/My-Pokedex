package com.example.mypokedex.domain.repositories

import com.example.mypokedex.domain.model.Pokemon

interface IObtainPokemonLocal {
    fun obtainFromJson(pokemonName: String): Pokemon
    fun obtainListFromJson(): List<*>
}