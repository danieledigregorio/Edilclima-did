package it.polito.did.edilclima.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import it.polito.did.edilclima.GameViewModel
import it.polito.did.edilclima.screens.LoginScreen
import it.polito.did.edilclima.screens.WaitingRoomScreen
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.rememberNavController
import it.polito.did.edilclima.navigation.tutorial.NavGraphTutorial
import it.polito.did.edilclima.screens.ImprevistoScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreensRouter() {
    val vm: GameViewModel = viewModel()
    val turno = vm.turno.observeAsState()
    val users = vm.users.observeAsState()
    val uid = vm.uid.observeAsState()
    val group = vm.group.observeAsState()
    val activities = vm.activities.observeAsState()
    val imprevisti = vm.imprevisti.observeAsState()
    val stats = vm.stats.observeAsState()

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
                gameCode = screenName.gamecode,
                teamCode = screenName.teamcode,
                turno = turno,
                users = users,
                uid = uid,
                group = group,
                activities = activities,
                stats = stats,
            )
        }
        is Screens.Imprevisto -> ImprevistoScreen(
            vm::onCloseImprevisto,
            imprevisti,
        )
        null -> LoginScreen(vm::onJoinGame)
    }
}