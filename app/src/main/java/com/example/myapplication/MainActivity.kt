package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.GridViewAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.GridDataModel
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.ViewModelFactoryProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var databinding : ActivityMainBinding
    lateinit var ViewModel: MainViewModel
    lateinit  var gridAdapet :GridViewAdapter

    var gridList = ArrayList<GridDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val factory = ViewModelFactoryProvider()
        ViewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        databinding.mainViewModel = ViewModel
        databinding.lifecycleOwner = this

        initRecylerView()

        listenObserver()

    }


    /*
    * init recyler view
    * */
    private fun initRecylerView(){
      /*  databinding.apply {
            rvGridView.apply {
                layoutManager = GridLayoutManager(this@MainActivity,2)
            }
        }*/
        gridAdapet = GridViewAdapter(this,gridList)
        rvGridView.layoutManager = GridLayoutManager(this@MainActivity,2)
        databinding.rvGridView.adapter = gridAdapet
    }

    private fun listenObserver(){

        databinding.lifecycleOwner?.let {
            ViewModel.gridList.observe(it,androidx.lifecycle.Observer {
                it?.let { gridListValue->

                    Log.d("--- list size","==="+gridListValue)


                }
            })
        }
    }
}