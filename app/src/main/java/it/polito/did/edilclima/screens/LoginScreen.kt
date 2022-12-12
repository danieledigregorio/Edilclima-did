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
import androidx.navigation.NavController
import it.polito.did.edilclima.R
import it.polito.did.edilclima.navigation.Screens
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Green2
import it.polito.did.edilclima.ui.theme.Shapes
import it.polito.did.edilclima.ui.theme.White1

@Composable
fun LoginScreen(
    navController: NavController,
    onWriteDB: (String, String) -> Unit
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
            .background(White1)
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
                        color = Black,
                    )},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = White1)
                        .border(2.dp, Green2, Shapes.small)
                        .onFocusChanged {
                            focus1 = it.isFocused
                        },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
                Divider(
                    Modifier.height(12.dp)
                )
                TextField(
                    value = gamername,
                    onValueChange = {
                        gamername = it
                    },
                    label = { Text(
                        text = "Il tuo nome",
                        color = Black,
                    )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = White1)
                        .border(2.dp, Green2, Shapes.small),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
                Divider(
                    Modifier.height(12.dp)
                )
                Button(
                    onClick = {
                        onWriteDB(gamecode, gamername)
                        navController.navigate(Screens.Home.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = gamecode.length==maxChar && gamername!="",
                ) {
                    Text(
                        text = "Accedi",
                        modifier = Modifier
                            .padding(8.dp),
                        color = White1,
                    )
                }
            }
            Row {
                Image(
                    painter = painterResource(R.drawable.logo_polito),
                    contentDescription = "Logo POLITO",
                    alpha = 0.75F,
                    modifier = Modifier
                        .size(100.dp)
                )
            }
        }
    }
}