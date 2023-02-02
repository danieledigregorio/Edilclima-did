package it.polito.did.edilclima.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import it.polito.did.edilclima.GameManager
import it.polito.did.edilclima.R
import it.polito.did.edilclima.Typography
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.White1
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ImprevistoScreen(
    onCloseImprevisto: () -> Unit,
    imprevisti: State<List<GameManager.Imprevisto>?>
) {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    var lastdate: String = "1950-01-01 12:00:00"
    imprevisti.value!!.map { if(LocalDateTime.parse(it.date, formatter).isAfter(LocalDateTime.parse(lastdate, formatter))) lastdate=it.date }
    val lastimprevisto: GameManager.Imprevisto = imprevisti.value!!.first { it.date == lastdate }
    val dataimprevisto: ImprevistoItem = getImprevistoById(lastimprevisto.id)

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
                    text = dataimprevisto.text,
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