package it.polito.did.edilclima

import android.content.Context
import android.os.Build
import android.os.*
import android.os.VibratorManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import it.polito.did.edilclima.navigation.Screens
import it.polito.did.edilclima.screens.getAzioni
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import androidx.core.content.ContextCompat.getSystemService


@RequiresApi(Build.VERSION_CODES.S)
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

    private val mutableActivities = MutableLiveData<List<Edit>>()
    val activities: LiveData<List<Edit>> = mutableActivities

    private val mutableGroups = MutableLiveData<List<Group>>()
    val groups: LiveData<List<Group>> = mutableGroups

    private val mutableGroup = MutableLiveData<Group>()
    val group: LiveData<Group> = mutableGroup

    private val mutableTurni = MutableLiveData<List<TurnoDB>>()
    val turni: LiveData<List<TurnoDB>> = mutableTurni

    private val mutableTurno = MutableLiveData<Turno>()
    val turno: LiveData<Turno> = mutableTurno

    private val mutableUsers = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = mutableUsers

    private val mutableImprevisti = MutableLiveData<List<Imprevisto>>()
    val imprevisti: LiveData<List<Imprevisto>> = mutableImprevisti

    private val mutableImprevisto = MutableLiveData<Imprevisto>()
    val imprevisto: LiveData<Imprevisto> = mutableImprevisto

    private val mutableStats = MutableLiveData<Stats>()
    val stats: LiveData<Stats> = mutableStats

    private val mutableClassifica = MutableLiveData<List<ClassificaItem>>()
    val classifica: LiveData<List<ClassificaItem>> = mutableClassifica

    private val mutableError = MutableLiveData<String>()
    val error: LiveData<String> = mutableError

    fun joinGame(gamecode:String, name:String) {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode)
                val data = refDB.get().await().value
                if(data!=null) {
                    val status = refDB.child("status").get().await().value
                    if(status!=null && status=="created") {
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
                        if(status=="game") mutableError.value = "La partita è già iniziata."
                        else if(status=="finished") mutableError.value = "La partita è terminata."
                    }
                } else {
                    mutableError.value = "Partita $gamecode non trovata."
                }
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore. Riprova."
            }
        }
    }

    private fun listenStartGame(gamecode: String) {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode).child("status")
                refDB.addValueEventListener(object : ValueEventListener {
                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val v = snapshot.value
                        if(v=="game") {
                            setTeamcode()
                        } else if(v=="finished") {
                            getClassifica()
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        mutableError.value = "Si è verificato un errore nel database."
                    }
                })
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
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
                            getUsers()
                            getGroups()
                            listenActivities()
                            calcStats()
                            mutableScreenName.value = Screens.GroupAssigned(mutableTeamcode.value!!)
                        }
                    }
                }
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    fun getUsers() {
        scope.launch {
            try {
                val refDB1 = firebaseDB.getReference(gamecode.value!!).child("users")
                val data1 = refDB1.get().await().value
                if(data1!=null) {
                    val itemtype = object : TypeToken<Map<String, User>>(){}.type
                    val map1 = Gson().fromJson<Map<String, User>>(Gson().toJson(data1), itemtype)
                    val res1 : MutableList<User> = mutableListOf()
                    map1.keys.map { map1[it]?.let { it1 -> res1.add(it1) } }
                    mutableUsers.value = res1
                }
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    fun getGroups() {
        scope.launch {
            try {
                val refDB1 = firebaseDB.getReference(gamecode.value!!).child("gruppi")
                val data = refDB1.get().await().value
                if(data!=null) {
                    val res: List<Group> = Gson().fromJson(Gson().toJson(data), Array<Group>::class.java).toList()
                    mutableGroups.value = res
                    mutableGroup.value = res.first { it.idGroup == mutableTeamcode.value }
                    listenTurni()
                }
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    fun listenTurni() {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(gamecode.value!!).child("turni")
                refDB.addValueEventListener(object : ValueEventListener {
                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.value!=null) {

                            val itemtype = object : TypeToken<List<TurnoDB>>(){}.type
                            val res = Gson().fromJson<List<TurnoDB>>(Gson().toJson(snapshot.value), itemtype)

                            mutableTurni.value = res
                            getLastTurn()
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        mutableError.value = "Si è verificato un errore nel database."
                    }
                })
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getLastTurn() {
        val turnigruppo = mutableTurni.value!!.filter { it.idGroup==mutableTeamcode.value }
        val numturno = turnigruppo.size
        val usersgroup = mutableGroups.value!!.first { it.idGroup == mutableTeamcode.value }.users
        var lasttime : String = "1950-01-01 12:00:00"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        turnigruppo.map { if(LocalDateTime.parse(it.date, formatter).isAfter(LocalDateTime.parse(lasttime, formatter))) lasttime=it.date }

        val indexuser = numturno%usersgroup.size
        val userid = usersgroup[indexuser]
        val username = mutableUsers.value!!.first { it.id==userid }

        mutableTurno.value = Turno(lasttime, username)
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
                        if(snapshot.value!=null) {
                            val itemtype = object : TypeToken<List<Imprevisto>>(){}.type
                            val res = Gson().fromJson<List<Imprevisto>>(Gson().toJson(snapshot.value), itemtype)
                            mutableImprevisti.value = res
                            mutableScreenName.value = Screens.Imprevisto()
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        mutableError.value = "Si è verificato un errore nel database."
                    }
                })
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    fun closeImprevisto() {
        mutableScreenName.value = Screens.Home(gamecode.value!!, teamcode.value!!)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addActivity(idEdit: String, idChoice: String) {
        scope.launch {
            try {
                val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
                val date : String = LocalDateTime.now().format(formatter)
                val refDB = firebaseDB.getReference(mutableGamecode.value!!)
                refDB.child("activities").child("G${mutableTeamcode.value!!}-E${idEdit}-D${date}").setValue(mapOf(
                    "idGroup" to mutableTeamcode.value!!,
                    "idEdit" to idEdit,
                    "idChoice" to idChoice,
                    "date" to date,
                )).await()

                val formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                val date2 : String = LocalDateTime.now().format(formatter2)
                refDB.child("turni").child(mutableTurni.value!!.size.toString()).setValue(mapOf(
                    "idGroup" to mutableTeamcode.value!!,
                    "date" to date2,
                )).await()

            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    fun listenActivities() {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(mutableGamecode.value!!).child("activities")
                refDB.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.value!=null) {
                            val itemtype = object : TypeToken<Map<String, Edit>>(){}.type
                            val map = Gson().fromJson<Map<String, Edit>>(Gson().toJson(snapshot.value), itemtype)
                            val res : MutableList<Edit> = mutableListOf()
                            map.keys.map { map[it]?.let { it1 -> res.add(it1) } }
                            mutableActivities.value = res.filter { it.idGroup==mutableTeamcode.value }
                            calcStats()
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        mutableError.value = "Si è verificato un errore nel database."
                    }
                })
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    fun calcStats() {
        var co2: Int = 0
        var soldi: Int = 3000
        var quality: Int = 0
        var classeenergetica: String = "f"

        if(mutableActivities.value!=null) {
            val azioni = getAzioni()
            azioni.map { a ->

                // CO2, PRICE
                val listact = mutableActivities.value!!.filter { it.idEdit==a.id }
                listact.map { e ->
                    val choice = a.options.first { it.id==e.idChoice }
                    co2 += choice.co2
                    soldi -= choice.price
                }

                // QUALITY
                if(listact.isNotEmpty()) {
                    var lastdate = "19500101120000"
                    listact.map { if(it.date.toLong()>=lastdate.toLong()) lastdate=it.date }
                    val idChoice = listact.first { it.date==lastdate }.idChoice
                    quality += a.options.first { it.id==idChoice }.quality
                } else {
                    if(a.options.filter { it.default }.isNotEmpty())
                    quality += a.options.first { it.default }.quality
                }

                // CLASSE ENERGETICA
                classeenergetica =
                    if(co2 in 0..9) "f"
                    else if(co2 in 10..19) "e"
                    else if(co2 in 20..29) "d"
                    else if(co2 in 30..39) "c"
                    else if(co2 in 40..49) "b"
                    else if(co2 > 50) "a"
                    else "f"

                Log.d("gamemanager", "B: $co2 $soldi $quality $classeenergetica")
            }
        }

        mutableStats.value = Stats(
            co2 = co2,
            soldi = soldi,
            quality = quality,
            classeenergetica = classeenergetica
        )
    }

    fun restartGame() {
        mutableScreenName.value = Screens.Login
    }

    fun getClassifica() {
        scope.launch {
            try {
                val refDB = firebaseDB.getReference(mutableGamecode.value!!).child("classifica")
                refDB.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.value!=null) {
                            val itemtype = object : TypeToken<List<ClassificaItem>>(){}.type
                            val res = Gson().fromJson<List<ClassificaItem>>(Gson().toJson(snapshot.value), itemtype)
                            mutableClassifica.value = res
                            mutableScreenName.value = Screens.Classifica()
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        mutableError.value = "Si è verificato un errore nel database."
                    }
                })
            } catch (e: Exception) {
                mutableError.value = "Si è verificato un errore."
            }
        }
    }

    fun closeError() {
        mutableError.value = ""
    }




    data class Edit(var idGroup: String, var idEdit: String, var idChoice: String, var date: String) {}
    data class Group(var idGroup: String, var users: List<String>) {}
    data class Imprevisto(var id: String, var date: String) {}
    data class Turno(var data: String, var user: User) {}
    data class TurnoDB(var idGroup: String, var date: String) {}
    data class User(var id: String, var name: String) {}
    data class Stats(var co2: Number, var soldi: Number, var quality: Number, var classeenergetica: String)
    data class ClassificaItem(var position: String, var idGroup: String)
}