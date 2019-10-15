package com.dvtri.weddingmanager.fragment.dirary.registrationParty

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.fragment.dirary.PartyModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_registration_party.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter


class FragmentRegistrationParty : Fragment(), View.OnClickListener {

    private var mFirebaseDatabase: DatabaseReference? = null
    private var mFirebaseInstance: FirebaseDatabase? = null
    private var idParty:String? =null
    private var arrListType: ArrayList<String> = ArrayList<String>()
    private var arrListStatus: ArrayList<String> = ArrayList<String>()
    private var arrCostType: ArrayList<String> = ArrayList<String>()
    private var arrListDays: ArrayList<Int> = ArrayList<Int>()
    private var arrListMonths: ArrayList<Int> = ArrayList<Int>()
    private var arrListYears: ArrayList<Int> = ArrayList<Int>()


    override fun onClick(v: View?) {
        when (v) {
            btnAddParty -> {
                createParty(
                    "",
                    edtPartyName.text.toString(),
                    spnStatusParty.selectedItem.toString(),
                    spnDay.selectedItem.toString() + "/" + spnMonth.selectedItem.toString() + "/" + spnYear.selectedItem.toString(),
                    edtOwnerParty.text.toString(),
                    edtCostParty.text.toString(),
                    spnTypeParty.selectedItem.toString(),
                    edtNoteParty.text.toString(),
                    1
                )
                activity!!.supportFragmentManager.popBackStack("FragmentDiaryParty", 0)
            }
            btnCancel ->{
                activity!!.supportFragmentManager.popBackStack("FragmentDiaryParty", 0)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_party, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initConnect()
        initData()
        initUI()
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
        arrCostType.run {
            clear()
            add("Tiền mặt")
            add("Gửi hộ (Vắng mặt)")
            add("Chuyển khoản")
            add("Quà tặng")
        }
        arrListDays.run {
            clear()
            for (i in 1..31){
                add(i)
            }

        }
        arrListMonths.run {
            clear()
            for (i in 1..12){
                add(i)
            }
        }
        arrListYears.run {
            clear()
            for (i in 2000..2099){
                add(i)
            }
        }
    }

    private fun initConnect() {
        mFirebaseInstance = FirebaseDatabase.getInstance()
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance!!.getReference("parties")

    }

    private fun initUI() {
        btnAddParty.setOnClickListener(this)
        btnCancel.setOnClickListener (this)
        val adapterType = ArrayAdapter<String>(this.context as Context,android.R.layout.simple_spinner_item,arrListType)
        val adapterStatus = ArrayAdapter<String>(this.context as Context,android.R.layout.simple_spinner_item,arrListStatus)
        val adapterCostType = ArrayAdapter<String>(this.context as Context,android.R.layout.simple_spinner_item,arrCostType)
        val adapterDays = ArrayAdapter<Int>(this.context as Context,android.R.layout.simple_spinner_item,arrListDays)
        val adapterMonths = ArrayAdapter<Int>(this.context as Context,android.R.layout.simple_spinner_item,arrListMonths)
        val adapterCostYears = ArrayAdapter<Int>(this.context as Context,android.R.layout.simple_spinner_item,arrListYears)

        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterCostType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterMonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterCostYears.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spnTypeParty.adapter = adapterType
        spnStatusParty.adapter = adapterStatus
        spnCostType.adapter = adapterCostType
        spnDay.adapter = adapterDays
        spnMonth.adapter = adapterMonths
        spnYear.adapter = adapterCostYears
    }

    private fun createParty(idUser:String,
        partyName: String,
        partyStatus: String,
        partyDate: String,
        partyOwner: String,
        partyCost: String,
        partyType: String,
        partyDetail: String,
        partyImage: Int
    ) {
        if (TextUtils.isEmpty(idParty)) {
            idParty = mFirebaseDatabase!!.push().getKey()
        }
        val party = PartyModel(idUser,partyName,
            partyStatus,partyDate,
            partyOwner,partyCost,
            partyType,partyDetail,partyImage)
        mFirebaseDatabase!!.child(idParty!!).setValue(party)

        mFirebaseDatabase!!.child(idParty!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val party = dataSnapshot.getValue(PartyModel::class.java)
                // Check for null
                if (party == null) {
                    Log.e(TAG, "Party data is null!")
                    return
                }
                Log.e(TAG, "User data is changed!" + party.partyName + ", " + party.partyCost)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read party", error.toException())
            }
        })
    }
}