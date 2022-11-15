package it.polito.did.edilclima.navigation

sealed class Screens (val route : String) {
    object Login: Screens("login")
    object Home: Screens("home")
}