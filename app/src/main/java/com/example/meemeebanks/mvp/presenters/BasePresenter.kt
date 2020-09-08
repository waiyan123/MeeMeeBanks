package com.example.meemeebanks.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.meemeebanks.mvp.views.BaseView

abstract class BasePresenter<V : BaseView> : ViewModel(){

    protected lateinit var mView: V

    open fun initPresenter(view : V) {
        mView = view
    }
}