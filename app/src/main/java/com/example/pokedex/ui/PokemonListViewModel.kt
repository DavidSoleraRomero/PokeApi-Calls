package com.example.pokedex.ui

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.IPokemonRepository
import com.example.pokedex.data.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val defaultPokemonRepository: IPokemonRepository
): ViewModel() {

    suspend fun callPokeApi(): List<Pokemon> {
        return defaultPokemonRepository.readPaginated()
    }

}