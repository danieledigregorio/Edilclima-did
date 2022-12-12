package it.polito.did.edilclima

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class GameViewModel: ViewModel() {
    private val gameManager = GameManager(viewModelScope)

    fun onWriteDB(code:String, name:String) = gameManager.joinGame(code, name)
}