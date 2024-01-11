package com.example.mypokedex.domain.model

import androidx.compose.ui.graphics.Color
import com.example.mypokedex.ui.theme.bug
import com.example.mypokedex.ui.theme.dark
import com.example.mypokedex.ui.theme.dragon
import com.example.mypokedex.ui.theme.electric
import com.example.mypokedex.ui.theme.fairy
import com.example.mypokedex.ui.theme.fighting
import com.example.mypokedex.ui.theme.fire
import com.example.mypokedex.ui.theme.flying
import com.example.mypokedex.ui.theme.ghost
import com.example.mypokedex.ui.theme.grass
import com.example.mypokedex.ui.theme.ground
import com.example.mypokedex.ui.theme.ice
import com.example.mypokedex.ui.theme.normal
import com.example.mypokedex.ui.theme.poison
import com.example.mypokedex.ui.theme.psychic
import com.example.mypokedex.ui.theme.rock
import com.example.mypokedex.ui.theme.steel
import com.example.mypokedex.ui.theme.water

enum class Types(val typeName: String, val color: Color) {
    FLYING(typeName = "flying", color = flying),
    FIRE(typeName = "fire", color = fire),
    BUG(typeName = "bug", color = bug),
    NORMAL(typeName = "normal", color = normal),
    DRAGON(typeName = "dragon", color = dragon),
    WATER(typeName = "water", color = water),
    ELECTRIC(typeName = "electric", color = electric),
    GRASS(typeName = "grass", color = grass),
    ICE(typeName = "ice", color = ice),
    FIGHTING(typeName = "fighting", color = fighting),
    POISON(typeName = "poison", color = poison),
    GROUND(typeName = "ground", color = ground),
    PSYCHIC(typeName = "psychic", color = psychic),
    ROCK(typeName = "rock", color = rock),
    GHOST(typeName = "ghost", color = ghost),
    DARK(typeName = "dark", color = dark),
    STEEL(typeName = "steel", color = steel),
    FAIRY(typeName = "fairy", color = fairy)
}