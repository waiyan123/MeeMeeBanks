package com.example.meemeebanks.activities

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meemeebanks.R
import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.mvp.presenters.MainPresenter
import com.example.meemeebanks.mvp.views.MainView
import com.example.meemeebanks.ui.adapters.BankRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    override fun navigateToBankDetail(bankVO: BankVO) {

    }

    override fun showBanksList(bankList: List<BankVO>) {
        rvBankAdapter.setNewData(bankList as ArrayList<BankVO>)
    }

    override fun showError(error: String) {
        showToast(error)
    }

    private lateinit var mPresenter : MainPresenter

    private lateinit var rvBankAdapter : BankRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onUiReady(this)

        setUpRvBank()
    }

    fun setUpRvBank() {

        rvBankAdapter = BankRecyclerAdapter{
                mPresenter.onClickedBankItem(it)
            }

            with(rv_banks) {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(
                    applicationContext,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                (layoutManager as LinearLayoutManager).scrollToPosition(0)
                adapter = rvBankAdapter

            }
    }
}
