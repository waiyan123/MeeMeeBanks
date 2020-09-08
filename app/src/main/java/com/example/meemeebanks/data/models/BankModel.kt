package com.example.meemeebanks.data.models

import androidx.lifecycle.LiveData
import com.example.meemeebanks.data.vos.BankVO

interface BankModel {

    fun getBankList(
        onFailure : (String?) -> Unit
    ) : LiveData<List<BankVO>>
}