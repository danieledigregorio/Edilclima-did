package it.polito.did.edilclima.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.navigation.ScreensGame
import it.polito.did.edilclima.ui.theme.*


@Composable
fun GameCucina(navController: NavController) {
    val scrollstate = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Row( // IMG AMBIENTE
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_cucina),
                    contentDescription = "Img Cucina"
                )
            }
            Divider(
                Modifier.height(40.dp),
                color = Transparent
            )
            Row( // MENU MODIFICHE
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .horizontalScroll(scrollstate)
                    .fillMaxHeight(0.6f)
            ) {
                itemModifica(
                    modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                    icon = painterResource(R.drawable.icon_pianocottura),
                    navController = navController,
                    idedit = "0006",
                )
                itemModifica(
                    modifier = Modifier,
                    icon = painterResource(R.drawable.icon_stoviglie),
                    navController = navController,
                    idedit = "0007",
                )
                itemModifica(
                    modifier = Modifier,
                    icon = painterResource(R.drawable.icon_forno),
                    navController = navController,
                    idedit = "0008",
                )
                itemModifica(
                    modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp),
                    icon = painterResource(R.drawable.icon_frigo),
                    navController = navController,
                    idedit = "0009",
                )
            }
        }
    }
}