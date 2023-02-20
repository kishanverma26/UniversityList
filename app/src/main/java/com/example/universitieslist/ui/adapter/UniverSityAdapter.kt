package com.example.universitieslist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.universitieslist.R
import com.example.universitieslist.databinding.UniversityNameItemBinding
import com.example.universitieslist.models.UniversityRes
import com.example.universitieslist.utils.OnAdapterClick

class UniverSityAdapter(var list: ArrayList<UniversityRes>,var onAdapterClick: OnAdapterClick) :
    RecyclerView.Adapter<UniverSityAdapter.ViewHolder>() {

    class ViewHolder(var bind: UniversityNameItemBinding) : RecyclerView.ViewHolder(bind.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var bind: UniversityNameItemBinding
        val view = LayoutInflater.from(parent.context)
        bind = DataBindingUtil.inflate(
            view,
            R.layout.university_name_item, parent, false
        )
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: UniverSityAdapter.ViewHolder, position: Int) {
        holder.bind.tvName.text ="University Name:"+ list.get(position).name
        holder.bind.tvLocation.text ="City :"+ list.get(position).state_province
        if (list.get(position).state_province.isNullOrEmpty()){
            holder.bind.tvLocation.visibility=View.GONE
        }
        holder.itemView.setOnClickListener {
            onAdapterClick.onItemClickListener(list.get(position),position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}