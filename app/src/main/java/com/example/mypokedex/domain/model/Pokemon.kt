package com.example.mypokedex.domain.model

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
    //var pokemonTypes: MutableList<Types> = mutableListOf(Types.valueOf(p.types[0].type.name), Types.valueOf(p.types[0].type.name)),
    var weight: Float,
    var height: Float,
    var pokemonStats: MutableList<Stat> = mutableListOf(
        /*Stat(p.stats[0].stat.name, p.stats[0].base_stat, HPColor),
        Stat(p.stats[1].stat.name, p.stats[1].base_stat, ATKColor),
        Stat(p.stats[2].stat.name, p.stats[2].base_stat, DEFColor),
        Stat(p.stats[5].stat.name, p.stats[5].base_stat, HPColor),*/
        Stat("EXP", p.base_experience, EXPColor)
    ),
    var image: String = p.sprites.other.home.front_default
)