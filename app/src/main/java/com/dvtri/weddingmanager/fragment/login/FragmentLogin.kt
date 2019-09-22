package com.dvtri.weddingmanager.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.activity.LoginActivity
import com.dvtri.weddingmanager.activity.MainActivity
import com.dvtri.weddingmanager.utility.Util
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin() : Fragment(), View.OnClickListener {
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
    }
}