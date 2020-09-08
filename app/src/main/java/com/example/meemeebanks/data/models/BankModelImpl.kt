package com.example.meemeebanks.data.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.network.dataagents.BankListDataAgentImpl
import com.example.meemeebanks.persistence.MyDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class BankModelImpl : BankModel,KoinComponent{

    private val bankListDataAgentImpl : BankListDataAgentImpl by inject()

    private val myDatabase : MyDatabase by inject()

    override fun getBankList(
        onFailure : (String?) -> Unit
    ) : LiveData<List<BankVO>> {

        bankListDataAgentImpl.getBankListData(
            { observable ->
                observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        myDatabase.bankDao().insertBanksList(it.bankList)
                    }
            },
            {
                onFailure(it)
            }
        )

        return Transformations.distinctUntilChanged(myDatabase.bankDao().getBanksList())
    }
}