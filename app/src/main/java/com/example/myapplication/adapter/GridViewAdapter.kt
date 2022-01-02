package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemGriedBinding
import com.example.myapplication.model.GridDataModel

class GridViewAdapter(mContext: Context, arrayList: ArrayList<GridDataModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var gridList : ArrayList<GridDataModel>?=null
    var context : Context?=null

    init {
        this.gridList = arrayList
        this.context = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gried, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val model = gridList!!.get(position)

        if (holder is ViewHolder)
        {
            holder.bindingRow
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class  ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        var bindingRow : ItemGriedBinding ?=null
        init {
            bindingRow = DataBindingUtil.bind(itemView)
        }

        fun bind(model: GridDataModel,position: Int)
        {

        }
    }
}