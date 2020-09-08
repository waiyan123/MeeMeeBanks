package com.example.meemeebanks.mvp.views

import com.example.meemeebanks.data.vos.BankVO

interface DetailsView : BaseView{

    fun showDetail(bankVO : BankVO)
}