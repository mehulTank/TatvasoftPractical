package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.ViewModelFactoryProvider

class MainActivity : AppCompatActivity() {

    lateinit var databinding : ActivityMainBinding
    lateinit var ViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val factory = ViewModelFactoryProvider()
        ViewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        databinding.mainViewModel = ViewModel
        databinding.lifecycleOwner = this

    }
}