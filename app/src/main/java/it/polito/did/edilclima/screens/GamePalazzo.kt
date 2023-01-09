package it.polito.did.edilclima.screens

import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import it.polito.did.edilclima.navigation.ScreensGame
import it.polito.did.edilclima.ui.theme.White1
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Transparent

@Composable
fun GamePalazzo(navController: NavController) {
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
                    text = "Squadra 1",
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
                        text = "29 kg",
                        style = Typography.h1
                    )
                    Image(
                        painter = painterResource(R.drawable.f),
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
                        text = "3000,00 €",
                        style = Typography.h1
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.palazzo),
                contentDescription = "Palazzo",
                modifier = Modifier
                    .size(550.dp)
                    .clickable { navController.navigate(ScreensGame.GameHome.route) }
            )
        }
    }
}