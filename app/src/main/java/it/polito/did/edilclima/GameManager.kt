package it.polito.did.edilclima

import android.util.Log
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

    private val mutableUID = MutableLiveData<String>()
    val uid: LiveData<String> = mutableUID

    private val mutableTeamcode = MutableLiveData<String>()
    val teamcode: LiveData<String> = mutableTeamcode

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
                        mutableUID.value = uid
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
                        if(v=="game") {
                            setTeamcode()
                        }
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

    fun setTeamcode() {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode.value!!).child("gruppi")
                val data = refDB.get().await().value
                if(data!=null) {
                    val res: List<Group> = Gson().fromJson(Gson().toJson(data), Array<Group>::class.java).toList()
                    res.forEach {
                        if(it.users.contains(mutableUID.value)) {
                            mutableTeamcode.value = it.idGroup
                            mutableScreenName.value = Screens.GroupAssigned(mutableTeamcode.value!!)
                        }
                    }
                }
            } catch (e: Exception) {
                // ERR
            }
        }
    }

    fun startGame() {
        mutableScreenName.value = Screens.Home(gamecode.value!!, teamcode.value!!)
        listenImprevisti()
    }

    private fun listenImprevisti() {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode.value!!).child("imprevisti")
                refDB.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val v = snapshot.value
                        if(v!=null) {
                            mutableScreenName.value = Screens.Imprevisto()
                        }
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

    fun closeImprevisto() {
        mutableScreenName.value = Screens.Home(gamecode.value!!, teamcode.value!!)
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
                        mutableEdit.value = res?.idChoice
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

    data class Edit(var idEdit: String, var idChoice: String, var idGroup: String) {}
    data class Group(var idGroup: String, var users: List<String>) {}
    data class Imprevisto(var id: String) {}
}