package com.dvtri.weddingmanager.fragment.dirary

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.activity.MainActivity
import com.dvtri.weddingmanager.fragment.dirary.registrationParty.FragmentRegistrationParty
import com.dvtri.weddingmanager.utility.Util
import com.dvtri.weddingmanager.utility.arrListParty
import com.dvtri.weddingmanager.utility.parties
import com.google.firebase.database.*
import com.google.firebase.database.annotations.Nullable
import kotlinx.android.synthetic.main.fragment_diary_wedding.*


class FragmentDiaryParty() : Fragment(), View.OnClickListener, PartyAdapter.ItemClickListener {
    override fun onItemClick(party: PartyModel) {

    }

    private var arrListType: ArrayList<String> = ArrayList<String>()
    private var arrListStatus: ArrayList<String> = ArrayList<String>()
    private var arrListYear: ArrayList<String> = ArrayList<String>()
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference(parties)
    private var partyAdapter:PartyAdapter?=null


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

        rcvListWedding.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, true)
        rcvListWedding.setHasFixedSize(true)
        partyAdapter = PartyAdapter(arrListParty,this)
        rcvListWedding.adapter = partyAdapter



        btnRegistration.setOnClickListener {
            Util.replaceFragment(
                this.context as MainActivity,
                FragmentRegistrationParty(),
                "FragmentRegistrationParty",
                "FragmentRegistrationParty"
            )
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
            for (i in 2000..2099) {
                add(i.toString())
            }
        }

        loadParty()
    }

    override fun onClick(p0: View?) {

    }

    private fun loadParty() {
        arrListParty = ArrayList<PartyModel>()
        Log.d(TAG, "loadFirstPage: ")
        //Lấy dữ liệu
        //lấy đối tượng FirebaseDatabase
        val database = FirebaseDatabase.getInstance()
        //Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
        val mDatabase = database.getReference(parties)
        //truy xuất và lắng nghe sự thay đổi dữ liệu
        mDatabase.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(@NonNull dataSnapshot: DataSnapshot, @Nullable s: String?) {
                val key = dataSnapshot.key
                val getChild = mDatabase.child(key!!)
                getChild.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(@NonNull dataSnapshot: DataSnapshot) {
                        val parties = dataSnapshot.getValue<PartyModel>(PartyModel::class.java)
                        arrListParty.add(PartyModel(
                            parties!!.idUser,
                            parties.partyName,
                            parties.partyStatus,
                            parties.partyDate,
                            parties.partyOwner,
                            parties.partyCost,
                            parties.partyType,
                            parties.partyDetail,
                            parties.partyImage
                            )
                        )
                        partyAdapter!!.loadData()
                    }
                    override fun onCancelled(@NonNull databaseError: DatabaseError) {

                    }
                })


            }


            override fun onChildChanged(@NonNull dataSnapshot: DataSnapshot, @Nullable s: String?) {

            }

            override fun onChildRemoved(@NonNull dataSnapshot: DataSnapshot) {

            }

            override fun onChildMoved(@NonNull dataSnapshot: DataSnapshot, @Nullable s: String?) {

            }

            override fun onCancelled(@NonNull databaseError: DatabaseError) {

            }
        })

    }

}