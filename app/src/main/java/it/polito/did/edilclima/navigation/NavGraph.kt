package it.polito.did.edilclima.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.polito.did.edilclima.GameManager
import it.polito.did.edilclima.GameViewModel
import it.polito.did.edilclima.screens.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navController: NavHostController,
    gameCode: String,
    teamCode: String,
    turno: State<GameManager.Turno?>,
    users: State<List<GameManager.User>?>,
    uid: State<String?>,
    group: State<GameManager.Group?>,
    activities: State<List<GameManager.Edit>?>,
    stats: State<GameManager.Stats?>
) {
    val vm: GameViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = ScreensGame.GameMain.route,
    ) {
        composable(route = ScreensGame.GameMain.route){
            GamePalazzo(
                navController,
                teamCode,
                stats,
            )
        }
        composable(route = ScreensGame.GameHome.route){
            Column() {
                NavbarRooms(navController, turno, users, uid, group, stats)
                GameHome(navController)
            }
        }
        composable(route = ScreensGame.GameSoggiorno.route){
            Column() {
                NavbarRooms(navController, turno, users, uid, group, stats)
                GameSoggiorno(navController)
            }
        }
        composable(route = ScreensGame.GameBagno.route){
            Column() {
                NavbarRooms(navController, turno, users, uid, group, stats)
                GameBagno(navController)
            }
        }
        composable(route = ScreensGame.GameCucina.route){
            Column() {
                NavbarRooms(navController, turno, users, uid, group, stats)
                GameCucina(navController)
            }
        }
        composable(route = ScreensGame.GameCamera.route){
            Column() {
                NavbarRooms(navController, turno, users, uid, group, stats)
                GameCamera(navController)
            }
        }
        composable(route = ScreensGame.GameBalcone.route){
            Column() {
                NavbarRooms(navController, turno, users, uid, group, stats)
                GameBalcone(navController)
            }
        }
        composable("${ScreensGame.GameModifica.route}/{id}"){
            val id = navController.currentBackStackEntry?.arguments?.getString("id").toString()
            backButton(navController = navController)
            if(id!="null") {
                GameModifica(navController, id, vm::onAddActivity, activities, turno, uid, stats)
            }
        }
    }
}