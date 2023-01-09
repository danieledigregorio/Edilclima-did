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
fun GameHome(navController: NavController) {
    val scrollstate = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row( // IMG AMBIENTE
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_casa),
                    contentDescription = "Img Casa"
                )
            }
            Row( // MENU MODIFICHE
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .horizontalScroll(scrollstate)
                    .fillMaxHeight(0.6f)
            ) {
                itemModifica(
                    modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                    title = "Pulizia pavimento",
                    subtitle = "Lorem ipsum dolor sita met sed uliquat",
                    icon = painterResource(R.drawable.icon_bagno),
                    navController = navController,
                    idedit = "0001",
                )
                itemModifica(
                    modifier = Modifier,
                    title = "Lampadine LED",
                    subtitle = "Lorem ipsum dolor sita met sed uliquat",
                    icon = painterResource(R.drawable.icon_bagno),
                    navController = navController,
                    idedit = "edit 2",
                )
                itemModifica(
                    modifier = Modifier,
                    title = "Lampadine LED",
                    subtitle = "Lorem ipsum dolor sita met sed uliquat",
                    icon = painterResource(R.drawable.icon_bagno),
                    navController = navController,
                    idedit = "edit 3",
                )
                itemModifica(
                    modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp),
                    title = "Lampadine LED",
                    subtitle = "Lorem ipsum dolor sita met sed uliquat",
                    icon = painterResource(R.drawable.icon_bagno),
                    navController = navController,
                    idedit = "edit 4",
                )
            }
        }
    }
}

@Composable
fun itemModifica(
    modifier: Modifier,
    title: String,
    subtitle: String,
    icon: Painter,
    navController: NavController,
    idedit: String,
) {
    Box(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Purple500,
            modifier = Modifier
                .width(250.dp)
                .fillMaxHeight()
                .padding(10.dp)
                .clickable { navController.navigate(ScreensGame.GameModifica.route.plus("/${idedit}")) },
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .offset(90.dp, 40.dp)
                    .alpha(0.3f),
                tint = Purple200
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(20.dp)
            ) {
                Column() {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        tint = White1,
                    )
                    Divider(
                        Modifier.height(10.dp),
                        color = Transparent
                    )
                }
                Column() {
                    Text(
                        text = title,
                        style = Typography.h2,
                    )
                    Text(
                        text = subtitle,
                        style = Typography.body2,
                    )
                }
            }
        }
    }
}