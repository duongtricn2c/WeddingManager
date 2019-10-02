package com.dvtri.weddingmanager.fragment.dirary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_diary_wedding.view.*
import android.view.animation.TranslateAnimation
import com.dvtri.weddingmanager.R


class PartyAdapter(val arrListParty: ArrayList<PartyModel>) :
    RecyclerView.Adapter<PartyAdapter.MyViewHolder>() {

    private var isOpen: Boolean = false

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


        val animate = TranslateAnimation(0f, 0f, 0f, holder.itemView.itemDetail.height.toFloat())
        animate.duration = 500
        animate.fillAfter = true


        val item = arrListParty[position]
        holder.itemView.tvPartyName.text = item.partyName
        holder.itemView.tvPartyStatus.text = item.partyStatus
        holder.itemView.tvPartyDate.text = item.partyDate
        holder.itemView.imgPartyType.setImageResource(item.partyImage)

        holder.itemView.setOnClickListener {
            if (!isOpen) {
                holder.itemView.itemDetail.startAnimation(animate)
                holder.itemView.itemDetail.visibility = View.VISIBLE
                holder.itemView.imgExpandMore.setImageResource(R.drawable.ic_expand_hide)


            } else {
                holder.itemView.itemDetail.startAnimation(animate)
                holder.itemView.itemDetail.visibility = View.GONE
                holder.itemView.imgExpandMore.setImageResource(R.drawable.ic_expand_more)

            }
            isOpen = !isOpen

        }

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}