package it.polito.did.edilclima.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Transparent
import it.polito.did.edilclima.ui.theme.White1

@Composable
fun GroupAssigned(
    onStartGame: () -> Unit,
    teamCode: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = "Sei stato assegnato alla",
                style = Typography.body2,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Squadra $teamCode",
                style = Typography.h1,
            )
            Divider(
                Modifier.height(20.dp),
                color = Transparent
            )
            Button(onClick = { onStartGame() }) {
                Text(
                    text = "Inizia il gioco",
                    color = Black,
                )
            }
        }
    }
}