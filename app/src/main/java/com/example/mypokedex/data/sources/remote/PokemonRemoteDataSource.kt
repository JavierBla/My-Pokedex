package com.example.mypokedex.data.sources.remote

import com.example.mypokedex.data.mappers.PokemonDeserialized
import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.domain.repositories.IObtainPokemonRemote
import com.example.mypokedex.domain.repositories.IPokemonAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

@AndroidEntryPoint
class PokemonRemoteDataSource: IObtainPokemonRemote {

    @Inject
    var retrofit: IPokemonAPI = AppModule.provideRetrofit()

    override fun obtainFromApi(pokemonName: String): Pokemon {
        val call = retrofit.getPokemon(pokemonName)

        val gson: Gson = GsonBuilder().registerTypeAdapter(
            Pokemon::class.java,
            PokemonDeserialized()
        ).create()

        val pokemonAPI = gson.fromJson(call.execute().body().toString(), Pokemon::class.java)

        return pokemonAPI
    }
}

@Module
@InstallIn(PokemonRemoteDataSource::class)
object AppModule {
    @Provides
    fun provideRetrofit() = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IPokemonAPI::class.java)
}