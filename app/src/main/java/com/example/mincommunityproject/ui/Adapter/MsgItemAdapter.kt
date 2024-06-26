package com.example.mincommunityproject.ui.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mincommunityproject.databinding.ViewholderMsgItemBinding
import com.example.mincommunityproject.model.MsgItemModel
import com.example.mincommunityproject.ui.Activity.ChatActivity
import com.example.mincommunityproject.ui.Activity.DetailsActivity

/**
 * 消息页面条目适配器
 * @author ming
 * @time 2024/6/3 09:16
 */
class MsgItemAdapter(private val context: Context) :
    RecyclerView.Adapter<MsgItemAdapter.ViewHolder>() {

    // ViewHolder内部类，用于绑定ViewholderMsgItemBinding
    inner class ViewHolder(val binding: ViewholderMsgItemBinding) :
        RecyclerView.ViewHolder(binding.root){
            init {
                binding.root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        // 启动DetailActivity并传递数据
                        val intent = Intent(context, ChatActivity::class.java).apply {
                            putExtra("TIME_ID", "假设有个id字段")
                        }
                        context.startActivity(intent)
                    }
                }
            }
        }

    // 创建ViewHolder的方法
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 获取LayoutInflater对象
        val inflater = LayoutInflater.from(parent.context)
        // 使用ViewholderMsgItemBinding绑定布局
        val binding = ViewholderMsgItemBinding.inflate(inflater, parent, false)
        // 返回一个新的ViewHolder实例
        return ViewHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size//返回长度

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //绑定数据
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