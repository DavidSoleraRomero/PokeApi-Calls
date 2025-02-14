package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemotePokemonRepository @Inject constructor(
    private val pokeApiService: PokeApiService
): IRemotePokemonRepository {

    override suspend fun readPaginated(): Response<PaginatedPokemonResponse> {
        return pokeApiService.readPaginated()
    }

    override suspend fun readOne(id: Int): Response<Pokemon> {
        return pokeApiService.readOne(id)
    }

}