package com.example.meemeebanks.network.dataagents

import com.example.meemeebanks.network.ApiEndPoints
import com.example.meemeebanks.network.responses.BankListResponse
import io.reactivex.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BankListDataAgentImpl : BankListDataAgent,KoinComponent{

    private val mainApi : ApiEndPoints by inject()

    override fun getBankListData(
        onSuccess: (Observable<BankListResponse>) -> Unit,
        onFailure: (String?) -> Unit
    ) {
        var observable : Observable<BankListResponse>
        val callBankListData = mainApi.getBankListData()
        callBankListData.enqueue(object : Callback<BankListResponse> {
            override fun onFailure(call: Call<BankListResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<BankListResponse>,
                response: Response<BankListResponse>
            ) {
                if(response.isSuccessful) {
                    observable = Observable.just(response.body())
                    onSuccess(observable)
                }
            }

        })
    }
}