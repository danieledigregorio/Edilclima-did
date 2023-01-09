package it.polito.did.edilclima

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class GameViewModel: ViewModel() {
    private val gameManager = GameManager(viewModelScope)

    fun onJoinGame(gamecode:String, name:String) = gameManager.joinGame(gamecode, name)
    fun onStartGame() = gameManager.startGame()
    fun onAddEdit(gamecode: String, idEdit: String, idChoice: String, idGroup: String) = gameManager.addEdit(gamecode, idEdit, idChoice, idGroup)
    fun onGetEdit(gamecode: String, idEdit: String, idGroup: String) = gameManager.getEdit(gamecode, idEdit, idGroup)

    val screenName = gameManager.screenName
    val gamecode = gameManager.gamecode
    val edit = gameManager.edit
}