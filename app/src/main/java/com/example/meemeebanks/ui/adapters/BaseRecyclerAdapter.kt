package com.example.meemeebanks.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.meemeebanks.ui.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<VH : BaseViewHolder<W>,W> : RecyclerView.Adapter<VH>(){

    protected var dataList = ArrayList<W>()

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(dataList[position],position)
    }

    fun setNewData(data : ArrayList<W>) {
        dataList = data
        notifyDataSetChanged()
    }

    fun appendNewData(data : ArrayList<W>) {
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearAllData() {
        dataList.clear()
        notifyDataSetChanged()
    }
}