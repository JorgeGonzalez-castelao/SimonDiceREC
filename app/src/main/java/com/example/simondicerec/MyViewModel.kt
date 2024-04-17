package com.example.simondicerec

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    /**
     * Generates a random number
     * @param max max number to generate
     * @return random number
     */
    fun generateRandomNumber(max: Int): Int {
        return (0..max - 1).random()
    }

    fun initGame() {
        resetRound()
        resetUserSecuence()
        resetBotSecuence()
        Data.state = Data.State.START
    }

    fun resetRound() {
        Data.round.value = 0
    }

    fun resetUserSecuence() {
        Data.UserSecuence.clear()
    }

    fun resetBotSecuence() {
        Data.botSecuence.clear()
    }

}