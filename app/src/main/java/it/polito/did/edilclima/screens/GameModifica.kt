package it.polito.did.edilclima.screens

import android.util.Log
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.*

@Composable
fun GameModifica(
    gameCode: String,
    navController: NavController,
    id: String,
    onGameEdit: (String, String, String) -> Unit,
    edit: State<String?>,
    onAddEdit: (String, String, String, String) -> Unit,
    teamCode: String
) {
    onGameEdit(gameCode, id, teamCode)

    val azione = getAzioneById(id)

    val (selected, setSelected) = remember {
        mutableStateOf("")
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
                            .clickable { if(edit.value!=a.id) setSelected(a.id) }
                    ) {
                        RadioButton(
                            selected = selected==a.id,
                            onClick = { setSelected(a.id) },
                            enabled = edit.value!=a.id
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
                                if(edit.value==a.id) {
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
                            Text(text = "10 kg")
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
                            Text(text = "5,00 €")
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
                    onClick = { onAddEdit(gameCode, id, selected, teamCode) },
                    modifier = Modifier
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = White1, disabledBackgroundColor = Gray2,
                    ),
                    enabled = selected!="" && edit.value!=selected
                ) {
                    Text(
                        text = "Conferma",
                        color = Black,
                        modifier = Modifier
                            .padding(8.dp),
                    )
                }
            }
        }
    }
}