package com.example.mincommunityproject.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mincommunityproject.databinding.ViewholderLeadersBinding
import com.example.mincommunityproject.model.CollectUserModel
/**
 * 排行榜条目适配器
 * @author ming
 * @time 2024/6/3 09:14
 */
class CollectItemAdapter : RecyclerView.Adapter<CollectItemAdapter.ViewHolder>() {

    // 内部 ViewHolder 类，用于绑定视图
    inner class ViewHolder(val binding: ViewholderLeadersBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderLeadersBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size// 返回数据集大小

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.binding.titleText.text = currentItem.name//设置标题文本
        holder.binding.rowTxt.text = (position + 4).toString()//设置行数文本
        holder.binding.scoreText.text = currentItem.score.toString()//设置分数文本

        val context = holder.binding.root.context
        val resourceId = context.resources.getIdentifier(
            currentItem.pic,
            "drawable",
            context.packageName
        )

        // 使用 Glide 加载图像资源到 ImageView
        Glide.with(context)
            .load(resourceId)
            .into(holder.binding.sivImg)
    }

    // 差异回调用于比较旧项和新项
    private val differCallback = object : DiffUtil.ItemCallback<CollectUserModel>() {
        override fun areItemsTheSame(
            oldItem: CollectUserModel,
            newItem: CollectUserModel
        ): Boolean {
            return oldItem.id == newItem.id// 检查项目 ID 是否相同
        }

        override fun areContentsTheSame(
            oldItem: CollectUserModel,
            newItem: CollectUserModel
        ): Boolean {
            return oldItem == newItem// 检查项目内容是否完全相同
        }
    }

    // 异步差异列表，用于计算列表项之间的差异
    val differ = AsyncListDiffer(this, differCallback)
}