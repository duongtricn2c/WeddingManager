package com.dvtri.weddingmanager.fragment.dirary

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dvtri.weddingmanager.R
import kotlinx.android.synthetic.main.fragment_diary_wedding.*

class FragmentDiaryWedding() : Fragment(), View.OnClickListener {

    private var arrListType: ArrayList<String> = ArrayList<String>()
    private var arrListStatus: ArrayList<String> = ArrayList<String>()
    private var arrListYear: ArrayList<String> = ArrayList<String>()
    private var arrListParty:ArrayList<PartyModel> = ArrayList<PartyModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary_wedding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initUI()

    }

    private fun initUI() {
        val adapterType = ArrayAdapter<String>(
            this.context as Context,
            android.R.layout.simple_spinner_item,
            arrListType
        )
        val adapterStatus = ArrayAdapter<String>(
            this.context as Context,
            android.R.layout.simple_spinner_item,
            arrListStatus
        )
        val adapterYear = ArrayAdapter<String>(
            this.context as Context,
            android.R.layout.simple_spinner_item,
            arrListYear
        )

        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinType.adapter = adapterType
        spinStatus.adapter = adapterStatus
        spinYear.adapter = adapterYear


        spinType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }
        spinStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }
        spinYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

        rcvListWedding.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,true)
        rcvListWedding.setHasFixedSize(true)
        rcvListWedding.adapter = PartyAdapter(arrListParty!!)

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
            for (i in 2000..2099) {
                add(i.toString())
            }
        }

        arrListParty.run {
            arrListParty.add(PartyModel("Đám cưới em Trân","Đã tham dự","22/08/2019","Bạn Quyên",500000,"Đám cưới","Chuyển khoản vắng mặt",R.drawable.wedding_couple))
            arrListParty.add(PartyModel("Sinh nhật Hùng","Chưa tham dự","17/12/2019","Bạn Hùng",200000,"Đám cưới","Chuyển khoản vắng mặt",R.drawable.birthday_cake))
            arrListParty.add(PartyModel("Đám hỏi bạn Trang","Đã tham dự","29/08/2019","Bạn Trang",500000,"Đám cưới","Chuyển khoản vắng mặt",R.drawable.proposal))
            arrListParty.add(PartyModel("Liên hoan dự release dự án","Chưa tham dự","02/11/2019","Sếp Trần",100000,"Đám cưới","Chuyển khoản vắng mặt",R.drawable.confetti))
            arrListParty.add(PartyModel("Đám cưới chị Huyền","Đã tham dự","21/08/2019","Chị Huyền",500000,"Đám cưới","Chuyển khoản vắng mặt",R.drawable.wedding_couple))
        }

    }

    override fun onClick(p0: View?) {

    }

}