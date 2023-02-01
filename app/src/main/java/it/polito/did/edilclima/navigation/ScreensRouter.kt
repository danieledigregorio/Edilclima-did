package it.polito.did.edilclima.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import it.polito.did.edilclima.GameViewModel
import it.polito.did.edilclima.screens.LoginScreen
import it.polito.did.edilclima.screens.WaitingRoomScreen
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.rememberNavController
import it.polito.did.edilclima.navigation.tutorial.NavGraphTutorial
import it.polito.did.edilclima.screens.ImprevistoScreen

@Composable
fun ScreensRouter() {
    val vm: GameViewModel = viewModel()
    val edit = vm.edit.observeAsState()
    val turno = vm.turno.observeAsState()
    val users = vm.users.observeAsState()
    val uid = vm.uid.observeAsState()
    val groupStats = vm.groupStats.observeAsState()

    when (val screenName = vm.screenName.observeAsState().value) {
        is Screens.Login -> LoginScreen(
            vm::onJoinGame
        )
        is Screens.WaitingRoom -> WaitingRoomScreen(
            screenName.gamecode,
        )
        is Screens.GroupAssigned -> {
            val navController = rememberNavController()
            NavGraphTutorial(
                navController = navController,
                vm::onStartGame,
                screenName.teamcode,
            )
        }
        is Screens.Home -> {
            val navController = rememberNavController()
            NavGraph(
                navController = navController,
                edit = edit,
                gameCode = screenName.gamecode,
                teamCode = screenName.teamcode,
                turno = turno,
                users = users,
                uid = uid,
                groupStats = groupStats,
            )
        }
        is Screens.Imprevisto -> ImprevistoScreen(
            vm::onCloseImprevisto
        )
        null -> LoginScreen(vm::onJoinGame)
    }
}