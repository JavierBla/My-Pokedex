package com.example.mypokedex.domain.pokemon

data class PokemonAPIData(
    val base_experience: Int = 0,
    val height: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val sprites: Sprites = Sprites(),
    val stats: List<Stat> = emptyList(),
    val types: List<Type> = emptyList(),
    val weight: Int = 0
)