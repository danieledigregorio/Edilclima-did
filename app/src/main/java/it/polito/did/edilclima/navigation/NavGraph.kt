package it.polito.did.edilclima.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.polito.did.edilclima.GameViewModel
import it.polito.did.edilclima.screens.*

@Composable
fun NavGraph(
    navController: NavHostController,
    edit: State<String?>,
    gameCode: String,
    teamCode: String
) {
    val vm: GameViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = ScreensGame.GameMain.route,
    ) {
        composable(route = ScreensGame.GameMain.route){
            GamePalazzo(
                navController,
                teamCode
            )
        }
        composable(route = ScreensGame.GameHome.route){
            Column() {
                NavbarRooms(navController)
                GameHome(navController)
            }
        }
        composable(route = ScreensGame.GameSoggiorno.route){
            Column() {
                NavbarRooms(navController)
                GameSoggiorno(navController)
            }
        }
        composable(route = ScreensGame.GameBagno.route){
            Column() {
                NavbarRooms(navController)
                GameBagno(navController)
            }
        }
        composable(route = ScreensGame.GameCucina.route){
            Column() {
                NavbarRooms(navController)
                GameCucina(navController)
            }
        }
        composable(route = ScreensGame.GameCamera.route){
            Column() {
                NavbarRooms(navController)
                GameCamera(navController)
            }
        }
        composable(route = ScreensGame.GameBalcone.route){
            Column() {
                NavbarRooms(navController)
                GameBalcone(navController)
            }
        }
        composable("${ScreensGame.GameModifica.route}/{id}"){
            val id = navController.currentBackStackEntry?.arguments?.getString("id").toString()
            backButton(navController = navController)
            if(id!="null") {
                GameModifica(gameCode, navController, id, vm::onGetEdit, edit, vm::onAddEdit, teamCode)
            }
        }
    }
}