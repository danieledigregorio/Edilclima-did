package it.polito.did.edilclima.navigation.tutorial

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Transparent

@Composable
fun NavGraphTutorial(
    navController: NavHostController,
    onStartGame: () -> Unit,
    teamCode: String,
) {
    NavHost(
        navController = navController,
        startDestination = ScreensTutorial.Tutorial1.route
    ) {
        composable(route = ScreensTutorial.Tutorial1.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Text(
                        text = "Sei stato assegnato alla",
                        style = Typography.body2,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Squadra $teamCode",
                        style = Typography.h1,
                    )
                    Divider(
                        Modifier.height(20.dp),
                        color = Transparent
                    )
                    Button(onClick = { navController.navigate(ScreensTutorial.Tutorial2.route) }) {
                        Text(
                            text = "Avanti",
                            color = Black,
                        )
                    }
                }
            }
        }
        composable(route = ScreensTutorial.Tutorial2.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Text(
                        text = "Tutorial 2",
                        style = Typography.h1,
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet.",
                        style = Typography.body2,
                        textAlign = TextAlign.Center
                    )
                    Divider(
                        Modifier.height(20.dp),
                        color = Transparent
                    )
                    Button(onClick = { navController.navigate(ScreensTutorial.Tutorial3.route) }) {
                        Text(
                            text = "Avanti",
                            color = Black,
                        )
                    }
                }
            }
        }
        composable(route = ScreensTutorial.Tutorial3.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Text(
                        text = "Tutorial 3",
                        style = Typography.h1,
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet.",
                        style = Typography.body2,
                        textAlign = TextAlign.Center
                    )
                    Divider(
                        Modifier.height(20.dp),
                        color = Transparent
                    )
                    Button(onClick = { navController.navigate(ScreensTutorial.Tutorial4.route) }) {
                        Text(
                            text = "Avanti",
                            color = Black,
                        )
                    }
                }
            }
        }
        composable(route = ScreensTutorial.Tutorial4.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Text(
                        text = "Tutorial 4",
                        style = Typography.h1,
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet.",
                        style = Typography.body2,
                        textAlign = TextAlign.Center
                    )
                    Divider(
                        Modifier.height(20.dp),
                        color = Transparent
                    )
                    Button(onClick = { onStartGame() }) {
                        Text(
                            text = "Inizia il gioco",
                            color = Black,
                        )
                    }
                }
            }
        }
    }
}