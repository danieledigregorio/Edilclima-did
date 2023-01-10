package it.polito.did.edilclima.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
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
fun GamePalazzo(
    navController: NavController,
    teamCode: String
) {



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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.palazzo_g4),
                    contentDescription = "Palazzo g4",
                    modifier = Modifier
                        .width(550.dp)
                        .clickable { navController.navigate(ScreensGame.GameHome.route) }
                )
                Image(
                    painter = painterResource(R.drawable.palazzo_g3),
                    contentDescription = "Palazzo g3",
                    modifier = Modifier
                        .width(550.dp)
                        .clickable { navController.navigate(ScreensGame.GameHome.route) }
                )
                Image(
                    painter = painterResource(R.drawable.palazzo_g2),
                    contentDescription = "Palazzo g2",
                    modifier = Modifier
                        .width(550.dp)
                        .clickable { navController.navigate(ScreensGame.GameHome.route) }
                )
                Image(
                    painter = painterResource(R.drawable.palazzo_g1),
                    contentDescription = "Palazzo g1",
                    modifier = Modifier
                        .width(550.dp)
                        .clickable { navController.navigate(ScreensGame.GameHome.route) },
                    colorFilter = ColorFilter.tint(Black, blendMode = BlendMode.Overlay)
                )
            }
        }
    }
}