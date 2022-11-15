package it.polito.did.edilclima.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.polito.did.edilclima.screens.HomeScreen
import it.polito.did.edilclima.screens.LoginScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route,
    ) {
        composable(route = Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
    }
}