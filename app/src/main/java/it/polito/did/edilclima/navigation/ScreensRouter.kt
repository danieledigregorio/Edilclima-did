package it.polito.did.edilclima.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import it.polito.did.edilclima.GameViewModel
import it.polito.did.edilclima.screens.LoginScreen
import it.polito.did.edilclima.screens.WaitingRoomScreen
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.rememberNavController
import it.polito.did.edilclima.screens.GroupAssigned

@Composable
fun ScreensRouter() {
    val vm: GameViewModel = viewModel()
    val edit = vm.edit.observeAsState()

    when (val screenName = vm.screenName.observeAsState().value) {
        is Screens.Login -> LoginScreen(
            vm::onJoinGame
        )
        is Screens.WaitingRoom -> WaitingRoomScreen(
            screenName.gamecode,
        )
        is Screens.GroupAssigned -> GroupAssigned(
            vm::onStartGame
        )
        is Screens.Home -> {
            val navController = rememberNavController()
            NavGraph(
                navController = navController,
                edit = edit,
                gameCode = screenName.gamecode,
            )
        }
        null -> LoginScreen(vm::onJoinGame)
    }
}