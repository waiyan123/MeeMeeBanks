package com.example.meemeebanks.network.responses

import com.example.meemeebanks.data.vos.BankVO
import com.google.gson.annotations.SerializedName

class BankListResponse (

    @SerializedName("code")
    val code : String?,

    @SerializedName("message")
    val message : String?,

    @SerializedName("data")
    val bankList : ArrayList<BankVO>
)
{

}