package com.example.mincommunityproject.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mincommunityproject.databinding.ViewholderMsgItemBinding
import com.example.mincommunityproject.model.MsgItemModel

class MsgItemAdapter : RecyclerView.Adapter<MsgItemAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ViewholderMsgItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderMsgItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.binding.msgItemTxt.text = currentItem.name
        holder.binding.msgItemDate.text = currentItem.date
        holder.binding.msgItemTxt.text = currentItem.txt

        val context = holder.binding.root.context
        val resourceId = context.resources.getIdentifier(
            currentItem.pic,
            "drawable",
            context.packageName
        )

        // 使用 Glide 加载图像资源到 ImageView
        Glide.with(context)
            .load(resourceId)
            .into(holder.binding.msgItemImg)
    }

    // 差异回调用于比较旧项和新项
    private val differCallback = object : DiffUtil.ItemCallback<MsgItemModel>() {
        override fun areItemsTheSame(
            oldItem: MsgItemModel,
            newItem: MsgItemModel
        ): Boolean {
            return oldItem.name == newItem.name// 检查项目 ID 是否相同
        }

        override fun areContentsTheSame(
            oldItem: MsgItemModel,
            newItem: MsgItemModel
        ): Boolean {
            return oldItem == newItem// 检查项目内容是否完全相同
        }
    }

    // 异步差异列表，用于计算列表项之间的差异
    val differ = AsyncListDiffer(this, differCallback)

}