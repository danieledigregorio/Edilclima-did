package it.polito.did.edilclima.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import it.polito.did.edilclima.GameManager
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Gray1
import it.polito.did.edilclima.ui.theme.Transparent
import it.polito.did.edilclima.ui.theme.White1
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavbarRooms(
    navController: NavController,
    turno: State<GameManager.Turno?>,
    users: State<List<GameManager.User>?>,
    uid: State<String?>,
    group: State<GameManager.Group?>,
    stats: State<GameManager.Stats?>
) {
    var countdown by remember {
        mutableStateOf(1.0F)
    }
    LaunchedEffect(key1 = countdown) {
        val refreshtime : Float = 1000F
        val turnduration : Float = 180F
        delay(refreshtime.toLong())
        if(countdown>0F) {
            countdown -= (1F/turnduration)*(refreshtime/1000F)
        } else {
            countdown = 1F
        }
    }

    var popupControl by remember {
        mutableStateOf(false)
    }

    val scrollstate = rememberScrollState()

    // TIME CALCs
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
    val dataturno : LocalDateTime = LocalDateTime.parse(turno.value!!.data.replaceFirst(' ', 'T')).plusSeconds(180)
    val datanow : LocalDateTime = LocalDateTime.now()

    val difference : Long = ChronoUnit.SECONDS.between(datanow, dataturno)

    // TURNO CALCs
    val index = group.value!!.users.indexOf(turno.value!!.user.id)
    val before = group.value!!.users.filter { group.value!!.users.indexOf(it)<index }
    val after = group.value!!.users.filter { group.value!!.users.indexOf(it)>index }

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
            .fillMaxWidth()
    ) {
        Column {
            if(turno.value!!.user.id==uid.value) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    progress = (difference.toFloat()/180),//countdown,
                    color = if ((difference.toFloat()/180)<0.2F) Color.Red else if((difference.toFloat()/180)<0.4F) Color.Yellow else Color.Green
                )
            }
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
                if(turno.value!!.user.id==uid.value) {
                    Card(
                        backgroundColor = if ((difference.toFloat()/180)<0.2F) Color.Red else if((difference.toFloat()/180)<0.4F) Color.Yellow else Color.Green,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .clickable { popupControl = true },
                    ) {
                        Text(
                            text = "È il tuo turno!",
                            color = if ((difference.toFloat()/180)<0.2F) White1 else if((difference.toFloat()/180)<0.4F) Black else Black,
                            modifier = Modifier.padding(10.dp, 3.dp, 10.dp, 0.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else {
                    Card(
                        backgroundColor = Gray1,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .clickable { popupControl = true },
                    ) {
                        Text(
                            text = "È il turno di ${turno.value!!.user.name}",
                            color = Black,
                            modifier = Modifier.padding(10.dp, 3.dp, 10.dp, 0.dp)
                        )
                    }
                }
                Icon(
                    painter = painterResource(R.drawable.icon_info),
                    contentDescription = "Icona Info",
                    tint = White1,
                    modifier = Modifier
                        .size(30.dp)
                        .alpha(0F),
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
                        text = "${stats.value?.co2} kg",
                        style = Typography.body2
                    )
                    Divider(
                        Modifier.width(10.dp),
                        color = Transparent
                    )
                    Image(
                        painter = painterResource(imgclasse),
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
                        text = "${stats.value?.soldi},00 €",
                        style = Typography.body2
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "${(if(difference/60>=0)difference / 60 else 0).toString().split(".")[0]}:${(if(difference%60>=0) difference%60 else 0).toString().padStart(2,'0')}",
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
                /*
                itemMenu(
                    Modifier.padding(0.dp, 0.dp, 25.dp, 0.dp),
                    icon = painterResource(R.drawable.icon_balcone),
                    title = "Balcone",
                    navController = navController,
                    route = ScreensGame.GameBalcone.route,
                )
                 */
            }
            Divider(
                Modifier.height(20.dp),
                color = Transparent
            )
        }
        if(popupControl) {
            Popup(
                alignment = Alignment.Center,
                onDismissRequest = { popupControl = false },
                properties = PopupProperties(
                    focusable = true,
                    dismissOnBackPress = true,
                ),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Black.copy(alpha = 0.85F))
                        .clickable { popupControl = false },
                    contentAlignment = Alignment.Center,
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.9F)
                            .fillMaxHeight(0.5F)
                            .clickable { popupControl = true }
                            .padding(10.dp),
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = White1
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                if(turno.value!!.user.id==uid.value) {
                                    Text(
                                        text = "È il tuo turno!",
                                        color = Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                    Text(
                                        text = "Fai la tua mossa! Ti rimane poco tempo!",
                                        color = Black,
                                        textAlign = TextAlign.Center,
                                    )
                                } else {
                                    Text(
                                        text = "È il turno di ${turno.value!!.user.name}!",
                                        color = Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                    Text(
                                        text = "Aspetta il tuo turno. Nel frattempo puoi navigare nella casa per preparare la tua prossima mossa!",
                                        color = Black,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = "Turni successivi:",
                                    color = Black,
                                )
                                after.map { u ->
                                    Text(
                                        text = users.value!!.first { it.id==u }.name,
                                        color = Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                    )
                                }
                                before.map { u ->
                                    Text(
                                        text = users.value!!.first { it.id==u }.name,
                                        color = Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                    )
                                }
                            }
                        }
                    }
                }
            }
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