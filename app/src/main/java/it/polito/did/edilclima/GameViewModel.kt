package it.polito.did.edilclima

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class GameViewModel: ViewModel() {
    private val gameManager = GameManager(viewModelScope)

    fun onJoinGame(gamecode:String, name:String) = gameManager.joinGame(gamecode, name)
    fun onStartGame() = gameManager.startGame()
    fun onCloseImprevisto() = gameManager.closeImprevisto()
    @RequiresApi(Build.VERSION_CODES.O)
    fun onAddActivity(idEdit: String, idChoice: String) = gameManager.addActivity(idEdit, idChoice)
    fun onRestartGame() = gameManager.restartGame()

    val screenName = gameManager.screenName
    val turno = gameManager.turno
    val users = gameManager.users
    val uid = gameManager.uid
    val group = gameManager.group
    val activities = gameManager.activities
    val imprevisti = gameManager.imprevisti
    val stats = gameManager.stats
    val classifica = gameManager.classifica
}