package com.example.mypokedex.data.mappers

import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.domain.model.Stat
import com.example.mypokedex.domain.model.Types
import com.example.mypokedex.ui.theme.ATKColor
import com.example.mypokedex.ui.theme.DEFColor
import com.example.mypokedex.ui.theme.EXPColor
import com.example.mypokedex.ui.theme.HPColor
import com.example.mypokedex.ui.theme.SPDColor
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class PokemonDeserialized: JsonDeserializer<Pokemon> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): Pokemon {
        json as JsonObject

        val id: Int = json.get("id").asInt
        val name: String = json.get("name").asString
        val weight: Float = json.get("weight").asFloat
        val height: Float = json.get("height").asFloat
        val image: String = json.get("sprites").asJsonObject
            .get("other").asJsonObject
            .get("official-artwork").asJsonObject
            .get("front_default").asString
        val pokemonTypes: MutableList<Types> = mutableListOf()
        val stats: MutableList<Stat> = mutableListOf()

        val statsList = json.get("stats").asJsonArray

        for (stat in statsList) {
            val statA = stat.asJsonObject.get("stat")

            when(statA.asJsonObject.get("name").asString) {
                "hp" -> { stats.add(Stat("HP",stat.asJsonObject.get("base_stat").asInt, HPColor)) }
                "attack" -> { stats.add(Stat("ATK",stat.asJsonObject.get("base_stat").asInt, ATKColor)) }
                "defense" -> { stats.add(Stat("DEF",stat.asJsonObject.get("base_stat").asInt, DEFColor)) }
                "speed" -> { stats.add(Stat("SPD",stat.asJsonObject.get("base_stat").asInt, SPDColor)) }
            }
        }

        val typesList = json.get("types").asJsonArray

        for (type in typesList) {
            val type0 = type.asJsonObject.get("type").asJsonObject
            val types = type0.get("name").asString

            when (types) {
                "normal" -> pokemonTypes.add(Types.NORMAL)
                "fire" -> pokemonTypes.add(Types.FIRE)
                "flying" -> pokemonTypes.add(Types.FLYING)
                "bug" -> pokemonTypes.add(Types.BUG)
                "dragon" -> pokemonTypes.add(Types.DRAGON)
                "water" -> pokemonTypes.add(Types.WATER)
                "electric" -> pokemonTypes.add(Types.ELECTRIC)
                "grass" -> pokemonTypes.add(Types.GRASS)
                "ice" -> pokemonTypes.add(Types.ICE)
                "fighting" -> pokemonTypes.add(Types.FIGHTING)
                "poison" -> pokemonTypes.add(Types.POISON)
                "ground" -> pokemonTypes.add(Types.GROUND)
                "psychic" -> pokemonTypes.add(Types.PSYCHIC)
                "rock" -> pokemonTypes.add(Types.ROCK)
                "ghost" -> pokemonTypes.add(Types.GHOST)
                "dark" -> pokemonTypes.add(Types.DARK)
                "steel" -> pokemonTypes.add(Types.STEEL)
                "fairy" -> pokemonTypes.add(Types.FAIRY)
            }
        }

        stats.add(Stat("EXP",json.get("base_experience").asInt, EXPColor))

        return Pokemon(id,name,pokemonTypes,weight,height,stats,image)
    }
}