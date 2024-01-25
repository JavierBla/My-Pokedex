package com.example.mypokedex.domain.repositories

import com.example.mypokedex.domain.model.Pokemon

interface IObtainPokemonRemote {
    fun obtainPokemonFromApi(pokemonName: String): Pokemon
    fun obtainListFromApi(): List<*>
}