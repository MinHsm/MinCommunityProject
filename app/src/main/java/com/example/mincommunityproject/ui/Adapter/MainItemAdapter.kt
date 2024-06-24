package com.example.mincommunityproject.ui.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ViewhodelMainItemBinding
import com.example.mincommunityproject.model.MainItem
import com.example.mincommunityproject.ui.Activity.DetailsActivity

/**
 * 主页面条目适配器
 * @author ming
 * @time 2024/6/3 09:15
 */
class MainItemAdapter(private val context: Context, private val itemList: List<MainItem>) :
    RecyclerView.Adapter<MainItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //绑定条目xml文件
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewhodelMainItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.viewhodel_main_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    //获取长度
    override fun getItemCount(): Int {
        return itemList.size
    }

    //将数据添加进去
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    inner class ViewHolder(private val binding: ViewhodelMainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = itemList[position]
                    // 启动DetailActivity并传递数据
                    val intent = Intent(context, DetailsActivity::class.java).apply {
                        putExtra("TIME_ID", "假设有个id字段")
                    }
                    context.startActivity(intent)
                }
            }
        }

        fun bind(item: MainItem) {
            binding.mItem = item
            binding.executePendingBindings()
        }
    }
}