package it.polito.did.edilclima.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
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
import it.polito.did.edilclima.ui.theme.*

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GameModifica(
    navController: NavController,
    id: String,
    onAddActivity: (String, String) -> Unit,
    activities: State<List<GameManager.Edit>?>,
    turno: State<GameManager.Turno?>,
    uid: State<String?>,
    stats: State<GameManager.Stats?>
) {

    val azione = getAzioneById(id)

    var edit : GameManager.Edit by remember {
        mutableStateOf(GameManager.Edit("0", id,
            if(azione.options.filter { it.default }.isNotEmpty())
                azione.options.first { it.default }.id else "",
            "0"))
    }
    if(activities.value!=null) {
        activities.value!!.filter { it.idEdit==id }.map {
            if(it.date>edit.date) edit=it
        }
    }

    val (selected, setSelected) = remember {
        mutableStateOf(edit.idChoice)
    }

    var popupControl by remember {
        mutableStateOf(false)
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
                .padding(25.dp),
        ) {
            Column() {
                Text(
                    text = azione.title,
                    style = Typography.h1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = azione.subtitle,
                    style = Typography.body1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Divider(
                    modifier = Modifier.height(40.dp),
                    color = Transparent,
                )
                azione.options.forEach { a ->
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { if(edit.idChoice!=a.id) setSelected(a.id) }
                    ) {
                        RadioButton(
                            selected = selected==a.id,
                            onClick = { setSelected(a.id) },
                            enabled = edit.idChoice!=a.id
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = a.title,
                                    style = Typography.h5,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 20.sp,
                                )
                                if(edit.idChoice==a.id) {
                                    Divider(
                                        modifier = Modifier.width(10.dp),
                                        color = Transparent
                                    )
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        contentColor = Black,
                                        color = Gray1,
                                    ) {
                                        Text(
                                            text = "SELECTED",
                                            style = Typography.h6,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 10.sp,
                                            color = Black,
                                            modifier = Modifier
                                                .padding(5.dp, 0.dp)
                                        )
                                    }
                                }
                            }
                            Text(
                                text = a.subtitle,
                                style = Typography.body2,
                            )
                        }
                    }
                    Divider(
                        thickness = 10.dp,
                        color = Color.Transparent,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically,) {
                            Icon(
                                painter = painterResource(R.drawable.meter_svgrepo_com),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Divider(
                                modifier = Modifier.width(10.dp),
                                color = Color.Transparent
                            )
                            Text(text = "${a.co2} kg")
                        }
                        Divider(
                            modifier = Modifier.width(20.dp),
                            color = Color.Transparent
                        )
                        Row(verticalAlignment = Alignment.CenterVertically,) {
                            Icon(
                                painter = painterResource(R.drawable.euro_svgrepo_com),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Divider(
                                modifier = Modifier.width(10.dp),
                                color = Color.Transparent
                            )
                            Text(text = "${a.price},00 €")
                        }
                    }
                    Divider(
                        thickness = 1.dp,
                        color = White1,
                        modifier = Modifier
                            .padding(0.dp, 15.dp)
                            .alpha(0.25f)
                    )
                }
                Divider(
                    thickness = 50.dp,
                    color = Transparent
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = White1)
                ) {
                    Text(
                        text = "Indietro",
                        color = Black,
                        modifier = Modifier
                            .padding(8.dp),
                    )
                }
                Button(
                    onClick = { popupControl=true },
                    modifier = Modifier
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = White1, disabledBackgroundColor = Gray2,
                    ),
                    enabled = selected!="" && edit.idChoice!=selected
                ) {
                    Text(
                        text = "Seleziona",
                        color = Black,
                        modifier = Modifier
                            .padding(8.dp),
                    )
                }
            }
        }
        if(popupControl) {
            Popup(
                alignment = Alignment.Center,
                onDismissRequest = { popupControl = false },
                properties = PopupProperties(
                    focusable = true,
                    dismissOnBackPress = true,
                )
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
                            .clickable { popupControl = true },
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = White1
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Text(
                                text = "SICUROOO????",
                                color = Black,
                            )
                            Divider(thickness = 20.dp, color = Transparent)
                            if(turno.value!!.user.id==uid.value) {
                                if(stats.value!!.soldi.toDouble() >= azione.options.first { it.id==selected }.price.toDouble()) {
                                    Button(
                                        onClick = {
                                            onAddActivity(id, selected);
                                            popupControl = false
                                        },
                                        modifier = Modifier
                                            .width(150.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = Black, disabledBackgroundColor = Gray2,
                                        ),
                                        enabled = selected!="" && edit.idChoice!=selected
                                    ) {
                                        Text(
                                            text = "Conferma",
                                            color = White1,
                                            modifier = Modifier
                                                .padding(8.dp),
                                        )
                                    }
                                } else {
                                    Text(
                                        text = "Saldo insufficiente",
                                        color = Black,
                                        modifier = Modifier
                                            .padding(8.dp),
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            } else {
                                Text(
                                    text = "Aspetta il tuo turno per confermare l'acquisto!",
                                    color = Black,
                                    modifier = Modifier
                                        .padding(8.dp),
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}