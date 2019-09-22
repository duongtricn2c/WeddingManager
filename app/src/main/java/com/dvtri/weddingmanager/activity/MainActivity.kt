package com.dvtri.weddingmanager.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.fragment.dirary.FragmentDiaryWedding
import com.dvtri.weddingmanager.fragment.saving.FragmentSavingBook
import kotlinx.android.synthetic.main.activity_main.*
import com.dvtri.weddingmanager.utility.Util.Companion.replaceFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

    }

    private fun initUI() {
        btnDiaryWedding.setOnClickListener(this)
        btnSavingBook.setOnClickListener(this)
        btnStatistical.setOnClickListener(this)
        replaceFragment(this,FragmentDiaryWedding(),"FragmentDiaryWedding","FragmentDiaryWedding")
    }

    override fun onClick(v: View?) {
        when (v) {
            btnDiaryWedding -> {
                replaceFragment(this,FragmentDiaryWedding(),"FragmentDiaryWedding","FragmentDiaryWedding")
            }
            btnSavingBook -> {
                replaceFragment(this,FragmentSavingBook(),"FragmentSavingBook","FragmentSavingBook")
            }

            btnStatistical -> {

            }
        }
    }

}