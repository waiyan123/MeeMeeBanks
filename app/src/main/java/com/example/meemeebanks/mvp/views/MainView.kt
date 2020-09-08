package com.example.meemeebanks.mvp.views

import com.example.meemeebanks.data.vos.BankVO

interface MainView : BaseView{

    fun showBanksList(bankList : List<BankVO>)

    fun showError(error : String)

    fun navigateToBankDetail(bankVO : BankVO)
}