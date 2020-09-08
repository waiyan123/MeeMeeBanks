package com.example.meemeebanks.mvp.presenters

import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.mvp.views.DetailsView

class DetailsPresenter : BasePresenter<DetailsView>() {

    fun onUiReady(bankVO: BankVO) {
        mView.showDetail(bankVO)
    }
}