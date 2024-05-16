package com.example.mincommunityproject.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ViewhodelMainItemBinding
import com.example.mincommunityproject.model.MainItem

class MainItemAdapter(private val context: Context, private val itemList: List<MainItem>) :
    RecyclerView.Adapter<MainItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewhodelMainItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.viewhodel_main_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    inner class ViewHolder(private val binding: ViewhodelMainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MainItem) {
            binding.mItem = item
            binding.executePendingBindings()
        }
    }
}