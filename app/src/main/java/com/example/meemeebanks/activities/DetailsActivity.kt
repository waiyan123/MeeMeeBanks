package com.example.meemeebanks.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.meemeebanks.R
import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.mvp.presenters.DetailsPresenter
import com.example.meemeebanks.mvp.views.DetailsView
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity(),DetailsView,View.OnClickListener{

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.img_back -> {
                finish()
            }
        }
    }

    override fun showDetail(bankVO: BankVO) {

        Glide.with(applicationContext)
            .load(bankVO.logoUrl)
            .placeholder(R.drawable.ic_account_circle_black_24dp)
            .into(img_bank_details_icon)

        tv_bank_details_title.text = bankVO.name
        tv_created_at.text = bankVO.created_at
        tv_updated_at.text = bankVO.updated_at
        if(bankVO.maxAmount!=null && bankVO.maxAmount != "") {
            tv_max_amount.text = "Max amount - "+bankVO.maxAmount
        }
        if(bankVO.description!=null && bankVO.description != "") {
            tv_description.text = bankVO.description
        }
    }

    companion object {
        const val BANK_VO_KEY = "bank_vo_key"
        fun newIntent(context: Context): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
            }
        }
    }

    private lateinit var mPresenter : DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        mPresenter = ViewModelProviders.of(this).get(DetailsPresenter::class.java)
        mPresenter.initPresenter(this)

        val bankItem = intent.getSerializableExtra(BANK_VO_KEY) as BankVO?

        if(bankItem!=null) {
            mPresenter.onUiReady(bankItem)
        }

        img_back.setOnClickListener(this)
    }
}