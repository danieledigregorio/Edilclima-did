package it.polito.did.edilclima.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.White1
import kotlin.reflect.KFunction0

@Composable
fun ImprevistoScreen(
    onCloseImprevisto: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_danger),
                    contentDescription = "Danger Icon",
                    modifier = Modifier.size(50.dp),
                )
            }
            Column {
                Text(
                    text = "Imprevisto",
                    style = Typography.h1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Divider(
                    thickness = 20.dp,
                    color = Color.Transparent,
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    style = Typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            Button(
                onClick = { onCloseImprevisto() },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = White1)
            ) {
                Text(
                    text = "Continua",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    color = Black,
                )
            }
        }
    }
}