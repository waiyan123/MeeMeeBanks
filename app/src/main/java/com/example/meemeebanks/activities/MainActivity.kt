package com.example.meemeebanks.activities

import android.os.Build
import android.os.Bundle
import android.transition.Fade
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meemeebanks.R
import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.mvp.presenters.MainPresenter
import com.example.meemeebanks.mvp.views.MainView
import com.example.meemeebanks.ui.adapters.BankRecyclerAdapter
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    override fun navigateToBankDetail(bankVO: BankVO,imageView : ImageView,textView: TextView) {
        val intent = DetailsActivity.newIntent(this)
        intent.putExtra(DetailsActivity.BANK_VO_KEY,bankVO)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imagePair = Pair.create(imageView as View, "logo_transition")
            val titlePair = Pair.create(textView as View,"title_transition")
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,imagePair,titlePair)
            ActivityCompat.startActivity(this,intent,options.toBundle())
        } else {
            startActivity(intent)
        }
    }

    override fun showBanksList(bankList: List<BankVO>) {
        rv_banks.visibility = View.VISIBLE
        rvBankAdapter.setNewData(bankList as ArrayList<BankVO>)
        showAnim(shimmer_rv_banks,false)
    }

    override fun showError(error: String) {
        showToast(error)
    }

    private lateinit var mPresenter : MainPresenter

    private lateinit var rvBankAdapter : BankRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        showAnim(shimmer_rv_banks,true)
        shimmer_rv_banks.visibility = View.VISIBLE
        shimmer_rv_banks.startShimmerAnimation()

        mPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onUiReady(this)

        setUpRvBank()
    }

    fun setUpRvBank() {

        rvBankAdapter = BankRecyclerAdapter{ i,imageView,textView ->
            mPresenter.onClickedBankItem(i,imageView,textView)
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

    private fun showAnim(shimmer: ShimmerFrameLayout, anim: Boolean) {
        if (anim) {
            shimmer.visibility = View.VISIBLE
            shimmer.startShimmerAnimation()
        } else {
            shimmer.visibility = View.GONE
            shimmer.stopShimmerAnimation()
        }
    }
}
