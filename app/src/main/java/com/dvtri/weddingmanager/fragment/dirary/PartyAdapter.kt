package com.dvtri.weddingmanager.fragment.dirary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_diary_wedding.view.*
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.dvtri.weddingmanager.R


class PartyAdapter(var arrListParty: ArrayList<PartyModel>, val mItemClickListener: ItemClickListener) :
    RecyclerView.Adapter<PartyAdapter.MyViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(party: PartyModel)
    }

    private var oldPostion:Int? = null
    private var animSlideDown: Animation? = null
    private var animSlideUp: Animation? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        animSlideDown = AnimationUtils.loadAnimation(parent.context, R.anim.move_down)
        animSlideUp = AnimationUtils.loadAnimation(parent.context, R.anim.move_up)
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
        holder.tvPartyName.text = item.partyName
        holder.tvPartyStatus.text = item.partyStatus
        holder.tvPartyDate.text = item.partyDate
        holder.imgPartyType.setImageResource(R.drawable.wedding_couple)
        holder.tvOwner.text = item.partyOwner
        holder.tvCost.text = item.partyCost.toString()
        holder.tvType.text = item.partyType
        holder.tvNote.text = "Ghi chú : " + item.partyDetail

        if (oldPostion == position) {
            holder.itemDetail.startAnimation(animSlideDown)
            holder.itemDetail.visibility = View.VISIBLE
            holder.imgExpandMore.setImageResource(R.drawable.ic_expand_hide)


        } else {
            holder.itemDetail.visibility = View.GONE
//            holder.itemDetail.startAnimation(animSlideUp)
            holder.imgExpandMore.setImageResource(R.drawable.ic_expand_more)
        }


        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(item)
            oldPostion = position
            notifyDataSetChanged()
        }

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvPartyName = view.findViewById(R.id.tvPartyName) as TextView
        val tvPartyStatus = view.findViewById(R.id.tvPartyStatus) as TextView
        val tvPartyDate = view.findViewById(R.id.tvPartyDate) as TextView
        val tvOwner = view.findViewById(R.id.tvOwner) as TextView
        val tvCost = view.findViewById(R.id.tvCost) as TextView
        val tvType = view.findViewById(R.id.tvType) as TextView
        val tvNote = view.findViewById(R.id.tvNote) as TextView
        val imgPartyType = view.findViewById(R.id.imgPartyType) as ImageView
        val imgExpandMore = view.findViewById(R.id.imgExpandMore) as ImageView
        val itemDetail = view.findViewById(R.id.itemDetail) as LinearLayout

    }

    fun loadData(){

        notifyDataSetChanged()
    }

    fun delItem(){
        notifyItemInserted(arrListParty.size - 1)
    }

}