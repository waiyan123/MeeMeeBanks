package com.example.meemeebanks.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.meemeebanks.R
import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.ui.viewholders.BankViewHolder

class BankRecyclerAdapter(private val adapterOnClick : (Int,ImageView,TextView) -> Unit) : BaseRecyclerAdapter<BankViewHolder,BankVO>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_bank_item,parent,false)
        return BankViewHolder(itemView,adapterOnClick)
    }
}