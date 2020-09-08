package com.example.meemeebanks.ui.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.meemeebanks.R
import com.example.meemeebanks.data.vos.BankVO
import kotlinx.android.synthetic.main.recycler_bank_item.view.*

class BankViewHolder(itemView : View, val adapterOnClick : (Int) -> Unit) : BaseViewHolder<BankVO>(itemView){

    override fun setData(data: BankVO, position: Int) {
        Glide.with(itemView.context.applicationContext)
            .load(data.logoThumbnail)
            .placeholder(R.drawable.ic_account_circle_black_24dp)
            .into(itemView.img_bank_item)

        itemView.tv_bank_item.text = data.name

        itemView.setOnClickListener {
            adapterOnClick(position)
        }
    }
}