package com.dvtri.weddingmanager.fragment.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.*

class FragmentLogin : Fragment(), View.OnClickListener {

    var animSlideUp: Animation? = null
    var animSlideDown: Animation? = null

    @SuppressLint("NewApi")
    override fun onClick(v: View?) {
        when (v) {
            imgLoginFB -> {
                val intent = Intent(this.activity, MainActivity::class.java)
                (activity)!!.startActivity(intent)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    private fun initUI() {
        imgLoginFB.setOnClickListener(this)
        val timer = object : CountDownTimer(200, 200) {
            override fun onFinish() {
                tvAccount.startAnimation(animSlideDown)
                tvPassword.startAnimation(animSlideDown)
            }

            override fun onTick(p0: Long) {
            }
        }
        timer.start()
        edtAccount.setOnFocusChangeListener { view, b ->
            if (edtPassword.text.length == 0) {
                tvPassword.startAnimation(animSlideDown)
            }
            if ( edtAccount.text.length == 0)
                tvAccount.startAnimation(animSlideUp)
            else
                tvAccount.clearAnimation()
        }

        edtPassword.setOnFocusChangeListener { view, b ->
            if (edtAccount.text.length == 0) {
                tvAccount.startAnimation(animSlideDown)
            }
            if ( edtPassword.text.length == 0)
                tvPassword.startAnimation(animSlideUp)
            else
                tvPassword.clearAnimation()
        }
        animSlideUp = AnimationUtils.loadAnimation(this.context, R.anim.slide_up)
        animSlideDown = AnimationUtils.loadAnimation(this.context, R.anim.slide_down)
    }


}