package com.dvtri.weddingmanager.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.fragment.login.FragmentLogin

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerLogin, FragmentLogin()).commit()

    }

}
