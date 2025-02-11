package com.example.rickandmorty.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.GetCharactersQuery
import com.example.rickandmorty.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableStateFlow<List<GetCharactersQuery.Result>>(emptyList())
    val characters = _characters.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            val result = repository.getCharacters()
            if (result.isNullOrEmpty()) {
                Log.w(
                    "CharacterViewModel",
                    "No characters were found or there was an error in the query"
                )
            }
            _characters.value = result ?: emptyList()
        }
    }
}

