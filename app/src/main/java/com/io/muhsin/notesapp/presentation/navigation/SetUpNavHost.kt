package com.io.muhsin.notesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.io.muhsin.notesapp.presentation.screens.MainScreen


sealed class Screens(val rout: String) {
    object MainScreen: Screens(rout = "main_screen")
    object DetailsScreen: Screens(rout = "details_screen")
    object AddScreen: Screens(rout = "add_screen")
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.rout
    ) {
        composable(route = Screens.MainScreen.rout) {
            MainScreen()
        }
        composable(route = Screens.DetailsScreen.rout ) {
        }
        composable(route = Screens.AddScreen.rout) {
        }
    }
}