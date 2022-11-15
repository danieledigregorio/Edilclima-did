package it.polito.did.edilclima.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import it.polito.did.edilclima.navigation.NavGraph
import it.polito.did.edilclima.navigation.Screens
import java.util.*

@Composable
fun LoginScreen(navController: NavController) {
    var gamevalue : String by remember { mutableStateOf("") }
    var nome : String by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Edilclima", style = MaterialTheme.typography.h3)
        TextField(
            value = gamevalue,
            onValueChange = {
                    e -> gamevalue = e
            },
            placeholder = { Text("Codice Partita")}
        )
        TextField(
            value = nome,
            onValueChange = {
                    e -> nome = e
            },
            placeholder = { Text("Nome")}
        )
        Button(onClick = {
            val firebase = Firebase.database("https://edilclima-did-default-rtdb.europe-west1.firebasedatabase.app")
            val refDB = firebase.getReference(gamevalue)
            refDB.child("users").child(UUID.randomUUID().toString()).setValue(mapOf(
                "nome" to nome,
                "id" to "10000",
            ))

            navController.navigate(Screens.Home.route)
        }) {
            Text("LOGIN")
        }
    }
}