package it.polito.did.edilclima.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import it.polito.did.edilclima.GameViewModel
import it.polito.did.edilclima.screens.LoginScreen
import it.polito.did.edilclima.screens.WaitingRoomScreen
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.compose.rememberNavController
import it.polito.did.edilclima.navigation.tutorial.NavGraphTutorial
import it.polito.did.edilclima.screens.Classifica
import it.polito.did.edilclima.screens.ImprevistoScreen
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Gray2
import it.polito.did.edilclima.ui.theme.Transparent
import it.polito.did.edilclima.ui.theme.White1

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
    val classifica = vm.classifica.observeAsState()
    val error = vm.error.observeAsState()

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
        is Screens.Classifica -> Classifica(vm::onRestartGame, classifica, group.value!!.idGroup)
        null -> LoginScreen(vm::onJoinGame)
    }

    error.value?.let {
        if(error.value!="") {
            Popup(
                alignment = Alignment.Center,
                onDismissRequest = { vm.onCloseError() },
                properties = PopupProperties(
                    focusable = true,
                    dismissOnBackPress = true,
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Black.copy(alpha = 0.85F))
                        .clickable { vm.onCloseError() },
                    contentAlignment = Alignment.Center,
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.9F)
                            .clickable {  },
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = White1
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.padding(10.dp, 30.dp)
                        ) {
                            error.value?.let {
                                Text(
                                    text = it,
                                    color = Black,
                                )
                            }
                            Divider(thickness = 20.dp, color = Transparent)
                            Button(
                                onClick = {
                                    vm.onCloseError()
                                },
                                modifier = Modifier
                                    .width(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Black, disabledBackgroundColor = Gray2,
                                ),
                            ) {
                                Text(
                                    text = "Chiudi",
                                    color = White1,
                                    modifier = Modifier
                                        .padding(8.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}