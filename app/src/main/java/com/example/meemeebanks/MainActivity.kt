package com.example.meemeebanks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.meemeebanks.network.MainApi
import com.example.meemeebanks.network.responses.BankListResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val mainApi = MainApi.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bankDataCall = mainApi.getBankListData()

        bankDataCall.enqueue(object : Callback<BankListResponse>{
            override fun onFailure(call: Call<BankListResponse>, t: Throwable) {
                Log.d("test---","Fail "+t.localizedMessage)
            }

            override fun onResponse(
                call: Call<BankListResponse>,
                response: Response<BankListResponse>
            ) {
                if(response.isSuccessful) {
                    Log.d("test---","code "+response.code().toString())
                    Log.d("test---","message "+response.message().toString())
                    Log.d("test---","size "+response.body()?.bankList?.size.toString())
                    response.body()?.bankList?.forEach {
                        Log.d("test---","bank name "+it.name)
                    }
                }
            }

        })
    }
}
