package it.polito.did.edilclima.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import it.polito.did.edilclima.GameManager
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.navigation.ScreensGame
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Gray1
import it.polito.did.edilclima.ui.theme.Transparent
import it.polito.did.edilclima.ui.theme.White1

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SettingsScreen(
    navController: NavHostController,
    users: State<List<GameManager.User>?>,
    uid: State<String?>,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
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
                        .clickable { navController.navigate(ScreensGame.GameHome.route) }
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(30.dp, 0.dp, 30.dp, 15.dp),
            ) {
                Text(
                    text = "Impostazioni",
                    style = Typography.h1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Divider(thickness = 30.dp, color = Transparent)
                Card(
                    shape = RoundedCornerShape(20.dp),
                    backgroundColor = Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 15.dp)
                        .border(1.dp, White1, shape = RoundedCornerShape(20.dp)),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Il tuo nome",
                            style = Typography.body2,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Text(
                            text = users.value!!.first { it.id == uid.value }.name,
                            style = Typography.body2,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                /*
                Card(
                    shape = RoundedCornerShape(20.dp),
                    backgroundColor = Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 15.dp)
                        .border(1.dp, White1, shape = RoundedCornerShape(20.dp))
                        .clickable { navController.navigate(ScreensGame.GameTutorial.route) }
                ) {
                    Row(
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Tutorial",
                            style = Typography.body1,
                            textAlign = TextAlign.Start,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            painter = painterResource(R.drawable.icon_back),
                            contentDescription = "Icona Next",
                            tint = White1,
                            modifier = Modifier
                                .size(30.dp)
                                .rotate(180F)
                        )
                    }
                }
                 */
                Text(
                    text = "Versione 1.0.0 - release 14/02/2023",
                    style = Typography.body2,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.3F)
                )
                Text(
                    text = "Digital Interaction Design - A.A. 2022/2023",
                    style = Typography.body2,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.3F)
                )
                Text(
                    text = "LM Ingegneria del Cinema e dei Mezzi di Comunicazione",
                    style = Typography.body2,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.3F)
                )
                Text(
                    text = "Politecnico di Torino",
                    style = Typography.body2,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.3F)
                )
            }
        }
    }
}