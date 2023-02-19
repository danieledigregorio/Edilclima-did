package it.polito.did.edilclima.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import it.polito.did.edilclima.GameManager
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.Transparent
import it.polito.did.edilclima.ui.theme.White1

@Composable
fun Classifica(
    onRestartGame: () -> Unit,
    classifica: State<List<GameManager.ClassificaItem>?>,
    groupId: String,
) {
    val position = (classifica.value!!.indexOf(classifica.value!!.first { it.idGroup==groupId })+1).toString()
    val image = when (position) {
        "1" -> R.drawable.first
        "2" -> R.drawable.second
        "3" -> R.drawable.third
        else -> R.drawable.icon_trofeo
    }
    val str1 = when (position) {
        "1" -> "Complimenti!"
        "2" -> "Ci siete andati vicini!"
        "3" -> "Non male!"
        else -> "Peccato!"
    }
    val str2 = when (position) {
        "1" -> "La tua squadra si è classificata prima!"
        "2" -> "La tua squadra si è classificata seconda!"
        "3" -> "La tua squadra si è classificata terza!"
        else -> "La tua squadra si è classificata quarta!"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "First",
                modifier = Modifier.size(150.dp),
            )
            Divider(thickness = 30.dp, color = Transparent)
            Text(
                text = str1,
                style = Typography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = str2,
                style = Typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Divider(thickness = 60.dp, color = Transparent)
            Button(
                onClick = { onRestartGame() },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = White1)
            ) {
                Text(
                    text = "Chiudi",
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