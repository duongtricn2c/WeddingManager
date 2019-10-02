package com.dvtri.weddingmanager.fragment.dirary.registrationParty

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_registration_party.*

class FragmentRegistrationParty : Fragment(), View.OnClickListener{
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_party,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        btnCancel.setOnClickListener{
            activity!!.supportFragmentManager.popBackStack("FragmentDiaryParty", 0)
        }
    }
}