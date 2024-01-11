package com.example.mypokedex.domain.model

data class Pokemon(
    var pokemonID: Int,
    var name: String,
    var types: MutableList<Types>,
    var weight: Float,
    var height: Float,
    var stats: MutableList<Stat>,
    var image: String
)
