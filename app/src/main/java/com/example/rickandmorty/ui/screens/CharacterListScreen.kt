package com.example.rickandmorty.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.rickandmorty.ui.components.CharacterItem
import com.example.rickandmorty.ui.viewmodel.CharacterViewModel

@Composable
fun CharacterListScreen(viewModel: CharacterViewModel, navController: NavController) {
    val characters by viewModel.characters.collectAsState()

    LazyColumn {
        characters.let {
            items(it) { character ->
                CharacterItem(character, navController)
            }
        }
    }
}