package it.polito.did.edilclima

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import it.polito.did.edilclima.navigation.Screens
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList


class GameManager(private val scope:CoroutineScope) {
    private val firebaseDB = Firebase.database("https://edilclima-did.firebaseio.com/")
    private val firebaseAuth = Firebase.auth


    private val mutableScreenName = MutableLiveData<Screens>().also {
        it.value = Screens.Login
    }
    val screenName: LiveData<Screens> = mutableScreenName

    private val mutableGamecode = MutableLiveData<String>()
    val gamecode: LiveData<String> = mutableGamecode

    private val mutableEdit = MutableLiveData<String>()
    val edit: LiveData<String> = mutableEdit

    fun joinGame(gamecode:String, name:String) {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode)
                val data = refDB.get().await().value
                if(data!=null) {
                    val status = refDB.child("status").get().await().value
                    if(status!=null) {
                        firebaseAuth.signInAnonymously().await()
                        val uid = firebaseAuth.uid!!
                        refDB.child("users").child(uid).setValue(mapOf(
                            "name" to name,
                            "id" to uid,
                        )).await()
                        mutableScreenName.value = Screens.WaitingRoom(gamecode)
                        mutableGamecode.value = gamecode
                        listenStartGame(gamecode)
                    }
                    else {
                        // ERR - La partità è già iniziata
                    }
                } else {
                    // ERR - Nessuna partita trovata con questo codice
                }
            } catch (e: Exception) {
                // ERR
            }
        }
    }

    private fun listenStartGame(gamecode: String) {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode).child("status")
                refDB.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val v = snapshot.value
                        if(v=="game") mutableScreenName.value = Screens.GroupAssigned
                    }
                    override fun onCancelled(error: DatabaseError) {
                        // ERR
                    }
                })
            } catch (e: Exception) {
                // ERR
            }
        }
    }

    fun startGame() {
        mutableScreenName.value = Screens.Home(gamecode.value!!)
    }

    fun addEdit(gamecode: String, idEdit: String, idChoice: String, idGroup: String) {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode)
                refDB.child("edits").child("G${idGroup}-E${idEdit}").setValue(mapOf(
                    "idGroup" to idGroup,
                    "idEdit" to idEdit,
                    "idChoice" to idChoice,
                )).await()
            } catch (e: Exception) {
                // ERR
            }
        }
    }


    fun getEdit(gamecode: String, idEdit: String, idGroup: String) {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode).child("edits").child("G${idGroup}-E${idEdit}")
                refDB.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val res = Gson().fromJson(Gson().toJson(snapshot.value), Edit::class.java)
                        mutableEdit.value = res.idChoice
                    }
                    override fun onCancelled(error: DatabaseError) {
                        // ERR
                    }
                })
                /*
                val data = refDB.get().await().value
                if(data!=null) {
                    Log.d("edit", "code: $gamecode")
                    val res = Gson().fromJson(Gson().toJson(data), Edit::class.java)
                    mutableEdit.value = res
                    Log.d("edit", "AAA $res")
                }
                 */
            } catch (e: Exception) {
                // ERR
            }
        }
    }

    data class Edit(var idEdit: String, var idChoice: String, var idGroup: String) {}
}