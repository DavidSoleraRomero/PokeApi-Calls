package com.example.pokedex.di

import com.example.pokedex.data.DefaultPokemonRepository
import com.example.pokedex.data.IPokemonRepository
import com.example.pokedex.data.remote.IRemotePokemonRepository
import com.example.pokedex.data.remote.PokeApiService
import com.example.pokedex.data.remote.RemotePokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindDefaultPokemonRepository(defaultPokemonRepository: DefaultPokemonRepository): IPokemonRepository

    @Binds
    abstract fun bindRemotePokemonRepository(remotePokemonRepository: RemotePokemonRepository): IRemotePokemonRepository

}

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providePokeApi(): PokeApiService =
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApiService::class.java)

}