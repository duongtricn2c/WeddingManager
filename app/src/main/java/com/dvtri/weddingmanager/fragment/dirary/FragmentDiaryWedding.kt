package com.dvtri.weddingmanager.fragment.dirary

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.dvtri.weddingmanager.R
import kotlinx.android.synthetic.main.fragment_diary_wedding.*

class FragmentDiaryWedding() : Fragment(), View.OnClickListener{

    private  var arrListType:ArrayList<String> = ArrayList<String>()
    private  var arrListStatus:ArrayList<String> = ArrayList<String>()
    private  var arrListYear:ArrayList<String> = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary_wedding,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initUI()

    }

    private fun initUI() {
        var adapterType = ArrayAdapter<String>(this.context as Context,android.R.layout.simple_spinner_item,arrListType)
        var adapterStatus = ArrayAdapter<String>(this.context as Context,android.R.layout.simple_spinner_item,arrListStatus)
        var adapterYear = ArrayAdapter<String>(this.context as Context,android.R.layout.simple_spinner_item,arrListYear)

        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinType.adapter = adapterType
        spinStatus.adapter = adapterStatus
        spinYear.adapter = adapterYear


        spinType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }
        spinStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }
        spinYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

    }

    private fun initData() {
        arrListType.run {
            clear()
            add("Đám cưới")
            add("Đám hỏi")
            add("Sinh nhật")
            add("Party")
        }
        arrListStatus.run {
            clear()
            add("Chưa tham dự")
            add("Đã tham dự")
        }
        arrListYear.run {
            clear()
            for (i in 2000..2099){
                add(i.toString())
            }
        }
    }

    override fun onClick(p0: View?) {

    }

}