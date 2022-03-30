package com.siddhesh.yepl.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.siddhesh.yepl.R
import com.siddhesh.yepl.databinding.RowItemBinding

class RestaurantListAdapter(var vmList: List<RowItemViewModel>) :
    RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_item, parent, false
        )
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RowItemViewModel) {
            binding.vm = item
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return vmList.size
    }

    fun setData(items: List<RowItemViewModel>) {
        vmList = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(vmList[position])
    }


}