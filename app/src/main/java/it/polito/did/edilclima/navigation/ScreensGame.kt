package it.polito.did.edilclima.navigation

sealed class ScreensGame(val route: String) {
    object GameMain: ScreensGame("game-palazzo")
    object GameHome: ScreensGame("game-home")
    object GameSoggiorno: ScreensGame("game-soggiorno")
    object GameBagno: ScreensGame("game-bagno")
    object GameCucina: ScreensGame("game-cucina")
    object GameCamera: ScreensGame("game-camera")
    object GameBalcone: ScreensGame("game-balcone")
    object GameModifica: ScreensGame("game-modifica")
}