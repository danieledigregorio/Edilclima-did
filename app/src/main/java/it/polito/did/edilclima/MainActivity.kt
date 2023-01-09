package it.polito.did.edilclima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import it.polito.did.edilclima.navigation.ScreensRouter
import it.polito.did.edilclima.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdilclimaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreensRouter()
                    /*
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                     */
                }
            }
        }
    }
}