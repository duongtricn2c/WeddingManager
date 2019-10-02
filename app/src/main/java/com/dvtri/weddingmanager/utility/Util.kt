package com.dvtri.weddingmanager.utility

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.activity.MainActivity

class Util {
    companion object {
        fun replaceFragment(context: MainActivity, fragment: Fragment, name: String, tag: String) {
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, name)
                .addToBackStack(tag)
                .commit()
        }

    }

}