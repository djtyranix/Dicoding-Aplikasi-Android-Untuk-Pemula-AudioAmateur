package com.nixstudio.audioamateur

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeadphoneAdapter(private val listHeadphone : ArrayList<Headphone>) : RecyclerView.Adapter<CardViewHeadphoneAdapter.CardViewViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data : Headphone)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class CardViewViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvType : TextView = itemView.findViewById(R.id.tv_item_type)
        var tvDetail : TextView = itemView.findViewById(R.id.tv_item_detail)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_headphone, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CardViewViewHolder,
        position: Int
    ) {
        val headphone = listHeadphone[position]

        Glide.with(holder.itemView.context)
            .load(headphone.photo)
            .apply(RequestOptions().override(550, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = headphone.name
        holder.tvType.text = headphone.type
        holder.tvDetail.text = headphone.detail

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHeadphone[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listHeadphone.size
    }

}