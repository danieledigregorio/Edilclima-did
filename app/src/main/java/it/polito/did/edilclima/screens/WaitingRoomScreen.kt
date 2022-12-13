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
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.White1

@Composable
fun WaitingRoomScreen(
    navController: NavController,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1250, easing = LinearEasing)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White1)
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
                    text = "8888",
                    style = Typography.h2,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    painter = painterResource(it.polito.did.edilclima.R.drawable.spinner_solid),
                    contentDescription = "Loading",
                    modifier = Modifier
                        .size(30.dp)
                        .rotate(angle),
                    tint = Black,
                )
                Divider(
                    modifier = Modifier.height(16.dp)
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