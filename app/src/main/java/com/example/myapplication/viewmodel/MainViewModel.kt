package com.example.myapplication.viewmodel

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(), Observable {

    var editTextValue = ""

    var columm = 0.0
    var row = 0

    fun onSubmitClick() {

        if (editTextValue.isNotBlank() && checkPerfectSquare(editTextValue.toDouble())) {
            columm = Math.sqrt(editTextValue.toDouble())
            Log.d("---", "--- create grid")
        } else {
            Log.d("----", "--- number not integer")
        }


    }

    fun checkPerfectSquare(number: Double): Boolean {
        //Square Root of Number
        val sq = Math.sqrt(number)

        //Floor value, nearest Integer Part  floor(983.2) = 983
        val f = Math.floor(sq)

        return sq == f
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}