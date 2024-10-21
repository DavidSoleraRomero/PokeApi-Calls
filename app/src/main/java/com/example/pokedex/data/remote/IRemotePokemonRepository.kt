package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import retrofit2.Response

interface IRemotePokemonRepository {

    suspend fun readPaginated(): Response<PaginatedPokemonResponse>
    suspend fun readOne(id: Int): Response<Pokemon>

}