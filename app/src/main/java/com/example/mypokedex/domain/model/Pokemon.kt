package com.example.mypokedex.domain.model

data class Pokemon(
    var id: Int,
    var name: String,
    var pokemonTypes: MutableList<Types>,
    var weight: Float,
    var height: Float,
    var pokemonStats: MutableList<Stat>,
    var image: String
)