package com.example.mypokedex.domain.model

import androidx.compose.ui.text.toUpperCase
import com.example.mypokedex.domain.pokemon.PokemonAPIData
import com.example.mypokedex.domain.pokemon.Sprites
import com.example.mypokedex.ui.theme.ATKColor
import com.example.mypokedex.ui.theme.DEFColor
import com.example.mypokedex.ui.theme.EXPColor
import com.example.mypokedex.ui.theme.HPColor

val p: PokemonAPIData = PokemonAPIData()

data class Pokemon(
    var id: Int,
    var name: String,
    var pokemonTypes: MutableList<Types>,
    var weight: Float,
    var height: Float,
    var pokemonStats: MutableList<Stat>,
    var image: String
)