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
    var animMoveLeft: Animation? = null
    var animMoveRight: Animation? = null
    var animFadeIn : Animation? = null
    var animScaleUp : Animation? = null
    var checkFirst : Boolean = true

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

        val timer = object  :CountDownTimer(200,100){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                imgLogo.startAnimation(animFadeIn)
            }

        }
        timer.start()

        val timer2 = object : CountDownTimer(2500, 100) {
            override fun onFinish() {
                imgLogo.startAnimation(animScaleUp)
            }
            override fun onTick(p0: Long) {
            }
        }
        timer2.start()

        val timer3 = object : CountDownTimer(3000, 100) {
            override fun onFinish() {

                tvAccount.visibility = View.VISIBLE
                tvPassword.visibility = View.VISIBLE
                imgLoginFB.visibility = View.VISIBLE
                imgLoginGG.visibility = View.VISIBLE
                edtAccount.visibility = View.VISIBLE
                edtPassword.visibility = View.VISIBLE

                tvAccount.startAnimation(animSlideDown)
                tvPassword.startAnimation(animSlideDown)
                imgLoginFB.startAnimation(animMoveLeft)
                edtAccount.startAnimation(animMoveRight)
                edtPassword.startAnimation(animMoveRight)
                imgLoginGG.startAnimation(animMoveRight)

            }
            override fun onTick(p0: Long) {
            }
        }
        timer3.start()

        edtAccount.setOnFocusChangeListener { view, b ->
            if (edtPassword.text.length == 0) {
                if (!checkFirst) {
                    tvPassword.startAnimation(animSlideDown)
                }
            }
            if ( edtAccount.text.length == 0)
                    tvAccount.startAnimation(animSlideUp)


            else
                tvAccount.clearAnimation()
            checkFirst = false
        }

        edtPassword.setOnFocusChangeListener { view, b ->
            if (edtAccount.text.length == 0) {
                if (!checkFirst) {
                    tvAccount.startAnimation(animSlideDown)
                }
            }
            if ( edtPassword.text.length == 0)
                tvPassword.startAnimation(animSlideUp)
            else
                tvPassword.clearAnimation()
            checkFirst = false
        }
        animSlideUp = AnimationUtils.loadAnimation(this.context, R.anim.slide_up)
        animSlideDown = AnimationUtils.loadAnimation(this.context, R.anim.slide_down)
        animMoveLeft = AnimationUtils.loadAnimation(this.context, R.anim.move_left)
        animMoveRight = AnimationUtils.loadAnimation(this.context, R.anim.move_right)
        animFadeIn = AnimationUtils.loadAnimation(this.context, R.anim.fade_in)
        animScaleUp = AnimationUtils.loadAnimation(this.context, R.anim.scale_up)
    }


}