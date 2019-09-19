package com.dvtri.weddingmanager.fragment.dirary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dvtri.weddingmanager.R
import kotlinx.android.synthetic.main.item_diary_wedding.view.*

class PartyAdapter(val arrListParty: ArrayList<PartyModel>) :
    RecyclerView.Adapter<PartyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_diary_wedding, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrListParty.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = arrListParty[position]
        holder.itemView.tvPartyName.text = item.partyName
        holder.itemView.tvPartyStatus.text = item.partyStatus
        holder.itemView.tvPartyDate.text = item.partyDate
        holder.itemView.imgPartyType.setImageResource(item.partyImage)

        holder.itemView.itemParty.setOnClickListener {

        }

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}