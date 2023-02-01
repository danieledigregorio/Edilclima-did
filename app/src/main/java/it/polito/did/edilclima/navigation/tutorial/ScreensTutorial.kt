package it.polito.did.edilclima.navigation.tutorial

sealed class ScreensTutorial(val route: String) {
    object Tutorial1 : ScreensTutorial("01")
    object Tutorial2 : ScreensTutorial("02")
    object Tutorial3 : ScreensTutorial("03")
    object Tutorial4 : ScreensTutorial("04")
}