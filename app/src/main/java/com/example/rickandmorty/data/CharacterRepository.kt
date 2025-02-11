package com.example.rickandmorty.data

import com.example.rickandmorty.GetCharactersQuery

interface CharacterRepository {
    suspend fun getCharacters(): List<GetCharactersQuery.Result>?
}