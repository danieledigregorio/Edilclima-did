package it.polito.did.edilclima

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class GameManager(private val scope:CoroutineScope) {
    private val firebaseDB = Firebase.database("https://edilclima-did.firebaseio.com/")
    private val firebaseAuth = Firebase.auth

    fun joinGame(code:String, name:String) {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(code)
                val data = refDB.get().await()
                if(data!=null) {
                    firebaseAuth.signInAnonymously().await()
                    val uid = firebaseAuth.uid!!
                    refDB.child("users").child(uid).setValue(mapOf(
                        "name" to name,
                        "id" to uid,
                    )).await()
                    // CHANGE SCREEN
                    //navController.navigate(Screens.Home.route)
                }
            } catch (e: Exception) {
                // ERRORE
            }
        }
    }
}