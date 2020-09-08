package com.example.meemeebanks.activities

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.meemeebanks.R
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.custom_toast.view.*

abstract class BaseActivity : AppCompatActivity(){

    fun showToast(msg : String) {
        val layout = layoutInflater.inflate(R.layout.custom_toast,linearLayout)
        val myToast = Toast(this)
        myToast.duration = Toast.LENGTH_SHORT
        myToast.setGravity(Gravity.CENTER,0,0)
        myToast.view = layout
        layout.custom_toast_message.text = msg
        myToast.show()
    }
}