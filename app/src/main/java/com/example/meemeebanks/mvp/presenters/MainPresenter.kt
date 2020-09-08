package com.example.meemeebanks.mvp.presenters

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.meemeebanks.activities.BaseActivity
import com.example.meemeebanks.data.models.BankModelImpl
import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.mvp.views.MainView
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainPresenter : BasePresenter<MainView>(), KoinComponent {

    private val bankListModel : BankModelImpl by inject()

    private var bankVOList = ArrayList<BankVO>()

    fun onUiReady(activity : BaseActivity) {
        bankListModel.getBankList {
            mView.showError(it!!)
        }
            .observe(activity,
                Observer {
                    mView.showBanksList(it)
                    bankVOList.addAll(it)
                })
    }

    fun onClickedBankItem(index : Int,imgView : ImageView,textView : TextView) {
        mView.navigateToBankDetail(bankVOList[index],imgView,textView)
    }
}