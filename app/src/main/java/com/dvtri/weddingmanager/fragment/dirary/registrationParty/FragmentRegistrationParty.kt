package com.dvtri.weddingmanager.fragment.dirary.registrationParty

import android.app.Activity
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


    override fun onClick(v: View?) {
        when(v){
            btnAddParty ->{
                createParty("chuot01",
                    "Đám cưới chuột",
                    "Đã tham dự",
                    "22/12/2019",
                    "Con chuột",
                    700000,
                "Đám cưới",
                    "gửi bì",
                    1)
//                createParty("tri01",
//                    edtPartyName.text.toString(),
//                    spnStatusParty.selectedItem.toString(),
//                    "11/11/2019",
//                    edtOwnerParty.text.toString(),
//                    600000,
//                    spnTypeParty.selectedItem.toString(),
//                    edtNoteParty.text.toString(),
//                    1)
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
    }

    private fun initConnect() {
        mFirebaseInstance = FirebaseDatabase.getInstance()
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance!!.getReference("parties")

    }

    private fun initUI() {
        btnAddParty.setOnClickListener(this)
        btnCancel.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack("FragmentDiaryParty", 0)
        }
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

        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spnTypeParty.adapter = adapterType
        spnStatusParty.adapter = adapterStatus



    }

    private fun createParty(
        idUser:String,
        partyName: String,
        partyStatus: String,
        partyDate: String,
        partyOwner: String,
        partyCost: Long,
        partyType: String,
        partyDetail: String,
        partyImage: Int
    ) {
        if (TextUtils.isEmpty(idParty)) {
            idParty = mFirebaseDatabase!!.push().getKey()
        }

        var party = PartyModel(idUser,partyName,
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