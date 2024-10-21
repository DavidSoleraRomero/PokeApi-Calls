package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon

data class PaginatedPokemonResponse(
    val count: Int,
    val next: String?,
    val prev: String?,
    val results: List<Pokemon>
)
