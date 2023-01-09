package it.polito.did.edilclima.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import it.polito.did.edilclima.R
import it.polito.did.edilclima.ui.theme.*

@Composable
fun LoginScreen(
    onJoinGame: (String, String) -> Unit
) {
    val maxChar = 4
    var gamecode : String by remember {
        mutableStateOf("")
    }
    var gamername : String by remember {
        mutableStateOf("")
    }
    var focus1 : Boolean by remember {
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
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.4F),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_edilclima),
                    contentDescription = "Logo EDILCLIMA",
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                TextField(
                    value = gamecode,
                    onValueChange = {
                        if(it.length<=maxChar) gamecode = it
                    },
                    label = { Text(
                        text = if(focus1) {
                            "Codice partita ${gamecode.length}/$maxChar"
                        } else {
                            "Codice partita"
                        },
                        color = White1,
                    )},
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.icon_joystick),
                            contentDescription = "Icon Joystick",
                            tint = White1
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, White1, Shapes.small)
                        .onFocusChanged {
                            focus1 = it.isFocused
                        },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = White1,
                        focusedIndicatorColor = Black,
                        unfocusedIndicatorColor = Black,
                        disabledIndicatorColor = Black,
                        backgroundColor = Transparent,
                    ),
                    textStyle = LocalTextStyle.current.copy(color = White1)
                )
                Divider(
                    Modifier.height(12.dp),
                    color = Transparent
                )
                TextField(
                    value = gamername,
                    onValueChange = {
                        gamername = it
                    },
                    label = { Text(
                        text = "Il tuo nome",
                        color = White1,
                    )},
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.icon_user),
                            contentDescription = "Icon User",
                            tint = White1
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, White1, Shapes.small),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = White1,
                        focusedIndicatorColor = Black,
                        unfocusedIndicatorColor = Black,
                        disabledIndicatorColor = Black,
                        backgroundColor = Transparent,
                    ),
                    textStyle = LocalTextStyle.current.copy(color = White1)
                )
                Divider(
                    Modifier.height(12.dp),
                    color = Transparent
                )
                Button(
                    onClick = {
                        onJoinGame(gamecode, gamername)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = gamecode.length==maxChar && gamername!="",
                    colors = ButtonDefaults.buttonColors(backgroundColor = White1, disabledBackgroundColor = Gray1)
                ) {
                    Text(
                        text = "Accedi",
                        modifier = Modifier
                            .padding(8.dp),
                        color = Black,
                    )
                }
            }
            Row {
                Image(
                    painter = painterResource(R.drawable.logo_polito),
                    contentDescription = "Logo POLITO",
                    alpha = 0.5F,
                    modifier = Modifier
                        .size(100.dp),
                )
            }
        }
    }
}