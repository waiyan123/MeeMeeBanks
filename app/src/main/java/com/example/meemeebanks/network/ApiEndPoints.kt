package com.example.meemeebanks.network

import com.example.meemeebanks.network.responses.BankListResponse
import com.example.meemeebanks.utils.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiEndPoints {

    @GET(BANK_LIST_END_POINT)
    fun getBankListData(@Header(APP_ID_KEY)app_id : String ?= APP_ID_VALUE,
                     @Header(SECRET_KEY)secret_key : String ?= SECRET_KEY_VALUE) : Call<BankListResponse>
}