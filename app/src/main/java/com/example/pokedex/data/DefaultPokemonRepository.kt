package com.example.pokedex.data
import com.example.pokedex.data.remote.IRemotePokemonRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonRepository @Inject constructor(
    private val remoteRepository: IRemotePokemonRepository
): IPokemonRepository {

    override suspend fun readPaginated(): List<Pokemon> {
        val pokemonResponse = remoteRepository.readPaginated()
        return if (pokemonResponse.isSuccessful)
                   pokemonResponse.body()!!.results
               else
                   listOf()
    }

    override suspend fun readOne(id: Int): Pokemon {
        val pokemonResponse = remoteRepository.readOne(id)
        return if (pokemonResponse.isSuccessful)
            pokemonResponse.body()!!
        else
            Pokemon("", "")
    }

}