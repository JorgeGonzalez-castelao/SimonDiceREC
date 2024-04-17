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
}