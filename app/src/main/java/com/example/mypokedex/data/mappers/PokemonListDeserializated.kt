package com.example.mypokedex.data.mappers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class PokemonListDeserializated: JsonDeserializer<List<String>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<String> {
        json as JsonObject

        val pokemonList = json.get("results").asJsonArray

        val pokemonNameList: MutableList<String> = mutableListOf()

        for (pokemon in pokemonList) {
            val name = pokemon.asJsonObject.get("name").asString
            pokemonNameList.add(name)
        }

        return pokemonNameList
    }
}