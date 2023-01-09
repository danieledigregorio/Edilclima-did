package it.polito.did.edilclima.navigation

import android.util.Log
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Transparent
import it.polito.did.edilclima.ui.theme.White1

@Composable
fun NavbarRooms(navController: NavController) {
    val scrollstate = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 15.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_back),
                    contentDescription = "Icona Back",
                    tint = White1,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.navigate(ScreensGame.GameMain.route) }
                )
                Icon(
                    painter = painterResource(R.drawable.icon_info),
                    contentDescription = "Icona Info",
                    tint = White1,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            Row( // STATUS BAR
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.meter_svgrepo_com),
                        contentDescription = "Icona Speedometer",
                        tint = White1,
                        modifier = Modifier.size(20.dp)
                    )
                    Divider(
                        Modifier.width(10.dp),
                        color = Transparent
                    )
                    Text(
                        text = "29 kg",
                        style = Typography.body2
                    )
                    Divider(
                        Modifier.width(10.dp),
                        color = Transparent
                    )
                    Image(
                        painter = painterResource(R.drawable.f),
                        contentDescription = "Classe energetica",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_euro),
                        contentDescription = "Icona Euro",
                        tint = White1,
                        modifier = Modifier.size(20.dp)
                    )
                    Divider(
                        Modifier.width(10.dp),
                        color = Transparent
                    )
                    Text(
                        text = "3000,00 €",
                        style = Typography.body2
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "2:05",
                        style = Typography.body2
                    )
                }
            }
            Divider(
                Modifier.height(10.dp),
                color = Transparent
            )
            Row( // MENU AMBIENTI
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .horizontalScroll(scrollstate),
            ) {
                itemMenu(
                    Modifier.padding(25.dp, 0.dp, 0.dp, 0.dp),
                    icon = painterResource(R.drawable.icon_casa),
                    title = "Tutta la casa",
                    navController = navController,
                    route = ScreensGame.GameHome.route,
                )
                itemMenu(
                    Modifier,
                    icon = painterResource(R.drawable.icon_soggiorno),
                    title = "Soggiorno",
                    navController = navController,
                    route = ScreensGame.GameSoggiorno.route,
                )
                itemMenu(
                    Modifier,
                    icon = painterResource(R.drawable.icon_bagno),
                    title = "Bagno",
                    navController = navController,
                    route = ScreensGame.GameBagno.route,
                )
                itemMenu(
                    Modifier,
                    icon = painterResource(R.drawable.icon_cucina),
                    title = "Cucina",
                    navController = navController,
                    route = ScreensGame.GameCucina.route,
                )
                itemMenu(
                    Modifier,
                    icon = painterResource(R.drawable.icon_camera),
                    title = "Camera da letto",
                    navController = navController,
                    route = ScreensGame.GameCamera.route,
                )
                itemMenu(
                    Modifier.padding(0.dp, 0.dp, 25.dp, 0.dp),
                    icon = painterResource(R.drawable.icon_balcone),
                    title = "Balcone",
                    navController = navController,
                    route = ScreensGame.GameBalcone.route,
                )
            }
            Divider(
                Modifier.height(20.dp),
                color = Transparent
            )
        }
    }
}

@Composable
fun itemMenu(
    modifier: Modifier,
    icon: Painter,
    title: String,
    navController: NavController,
    route: String
) {
    val active = navController.currentBackStackEntry?.destination?.route == route
    val background = if(active) White1 else Black
    val color = if(active) Black else White1
    val fontWeight = if(active) FontWeight.Bold else FontWeight.Normal
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = background,
            modifier = Modifier
                .height(85.dp)
                .width(85.dp)
                .padding(10.dp)
                .border(1.dp, White1, shape = RoundedCornerShape(20.dp))
                .clickable { navController.navigate(route) },
        ) {
            Icon(
                painter = icon,
                contentDescription = "Icona Speedometer",
                tint = color,
                modifier = Modifier.padding(20.dp)
            )
        }
        Text(
            text = title,
            style = Typography.body2,
            fontSize = 10.sp,
            fontWeight = fontWeight,
        )
    }
}

@Composable
fun backButton(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 15.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_back),
                    contentDescription = "Icona Back",
                    tint = White1,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.popBackStack() }
                )
            }
        }
    }
}