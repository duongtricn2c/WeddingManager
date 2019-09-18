package com.dvtri.weddingmanager.utility

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dvtri.weddingmanager.R

class Util {
    companion object {
        fun replaceFragment(context: Context, fragment: Fragment, name: String, tag: String) {
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, name)
                .addToBackStack(tag)
                .commit()
        }
    }

}