package com.example.meemeebanks.network.dataagents

import com.example.meemeebanks.network.responses.BankListResponse
import io.reactivex.Observable

interface BankListDataAgent {

    fun getBankListData(
        onSuccess : (Observable<BankListResponse>) -> Unit,
        onFailure: (String?) -> Unit
    )
}