package it.polito.did.edilclima.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Transparent
import it.polito.did.edilclima.ui.theme.White1

@Composable
fun WaitingRoomScreen(
    gamecode: String,
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://assets4.lottiefiles.com/packages/lf20_Fo4x1KH8Aq.json"))


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = "Waiting Room",
                style = Typography.h1,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Codice partita",
                    style = Typography.body2,
                )
                Text(
                    text = gamecode,
                    style = Typography.h2,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .size(65.dp),
                )
                Divider(
                    Modifier.height(20.dp),
                    color = Transparent
                )
                Text(
                    text = "Stai per essere collegato alla partita desiderata.\nRimani in questa schermata.",
                    style = Typography.body2,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}