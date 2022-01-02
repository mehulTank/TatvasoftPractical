package com.example.myapplication.viewmodel

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.GridDataModel

class MainViewModel : ViewModel(), Observable {

    var editTextValue = ""

    var columm = 0.0

    private  val _gridListValue = MutableLiveData<List<GridDataModel>>()
    val  gridList : LiveData<List<GridDataModel>>  = _gridListValue

    var tempGridList = ArrayList<GridDataModel>()

    fun onSubmitClick() {

        if (editTextValue.isNotBlank() && checkPerfectSquare(editTextValue.toDouble())) {
            columm = Math.sqrt(editTextValue.toDouble())

            for (i in 0..columm.toInt())
            {
                var gridDataModel = GridDataModel()
                tempGridList.add(gridDataModel)
            }

            //gridList.value
            _gridListValue.postValue(tempGridList)

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