package com.example.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmorty.ui.screens.CharacterDetailScreen
import com.example.rickandmorty.ui.screens.CharacterListScreen
import com.example.rickandmorty.ui.screens.SplashScreen
import com.example.rickandmorty.ui.viewmodel.CharacterViewModel

@Composable
fun NavigationGraph(navController: NavHostController, viewModel: CharacterViewModel) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("character_list") {
            CharacterListScreen(viewModel, navController)
        }
        composable("character_detail/{id}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("id") ?: ""
            val character = viewModel.characters.value?.find { it.id == characterId }
            if (character != null) {
                CharacterDetailScreen(character, navController)
            }
        }
    }
}
