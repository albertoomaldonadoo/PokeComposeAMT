package com.turingalan.pokemon.di

import com.turingalan.pokemon.data.repository.PokemonInMemoryRepository
import com.turingalan.pokemon.data.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindPokemonRepository(repository: PokemonInMemoryRepository): PokemonRepository
}