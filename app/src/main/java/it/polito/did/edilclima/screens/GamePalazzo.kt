package it.polito.did.edilclima.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import it.polito.did.edilclima.GameManager
import it.polito.did.edilclima.navigation.ScreensGame
import it.polito.did.edilclima.ui.theme.White1
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Transparent

@Composable
fun GamePalazzo(
    navController: NavController,
    teamCode: String,
    stats: State<GameManager.Stats?>
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://assets8.lottiefiles.com/packages/lf20_paGW5dv4sm.json"))


    val imgclasse = when (stats.value?.classeenergetica) {
        "a" -> R.drawable.a
        "b" -> R.drawable.b
        "c" -> R.drawable.c
        "d" -> R.drawable.d
        "e" -> R.drawable.e
        else -> R.drawable.f
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp, 25.dp, 15.dp, 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp, 0.dp)
            ) {
                Text(
                    text = "Squadra $teamCode",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
                Divider(
                    Modifier.height(20.dp),
                    color = Transparent,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.meter_svgrepo_com),
                        contentDescription = "Icona Speedometer",
                        tint = White1,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "${stats.value?.co2} kg",
                        style = Typography.h1
                    )
                    Image(
                        painter = painterResource(imgclasse),
                        contentDescription = "Classe energetica",
                        modifier = Modifier.size(50.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_euro),
                        contentDescription = "Icona Euro",
                        tint = White1,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "${stats.value?.soldi},00 €",
                        style = Typography.h1
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.palazzo_g4),
                        contentDescription = "Palazzo g4",
                        modifier = Modifier
                            .width(550.dp)
                            .clickable { if (teamCode == "4") navController.navigate(ScreensGame.GameHome.route) },
                        alpha = if(teamCode=="4") 1F else 0.6F,
                    )
                    if(teamCode=="4") {
                        LottieAnimation(
                            composition = composition,
                            iterations = LottieConstants.IterateForever,
                            modifier = Modifier
                                .size(100.dp)
                                .rotate(-45F)
                                .offset(30.dp, 30.dp),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.palazzo_g3),
                        contentDescription = "Palazzo g3",
                        modifier = Modifier
                            .width(550.dp)
                            .clickable { if (teamCode == "3") navController.navigate(ScreensGame.GameHome.route) },
                        alpha = if(teamCode=="3") 1F else 0.5F
                    )
                    if(teamCode=="3") {
                        LottieAnimation(
                            composition = composition,
                            iterations = LottieConstants.IterateForever,
                            modifier = Modifier
                                .size(100.dp)
                                .rotate(-45F)
                                .offset(30.dp, 30.dp),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.palazzo_g2),
                        contentDescription = "Palazzo g2",
                        modifier = Modifier
                            .width(550.dp)
                            .clickable { if (teamCode == "2") navController.navigate(ScreensGame.GameHome.route) },
                        alpha = if(teamCode=="2") 1F else 0.5F
                    )
                    if(teamCode=="2") {
                        LottieAnimation(
                            composition = composition,
                            iterations = LottieConstants.IterateForever,
                            modifier = Modifier
                                .size(100.dp)
                                .rotate(-45F)
                                .offset(30.dp, 30.dp),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.palazzo_g1),
                        contentDescription = "Palazzo g1",
                        modifier = Modifier
                            .width(550.dp)
                            .clickable { if (teamCode == "1") navController.navigate(ScreensGame.GameHome.route) },
                        alpha = if(teamCode=="1") 1F else 0.5F
                    )
                    if(teamCode=="1") {
                        LottieAnimation(
                            composition = composition,
                            iterations = LottieConstants.IterateForever,
                            modifier = Modifier
                                .size(100.dp)
                                .rotate(-45F)
                                .offset(30.dp, 30.dp),
                        )
                    }
                }
            }
        }
    }
}