package com.example.mincommunityproject.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mincommunityproject.databinding.ChatMsgItemBinding
import com.example.mincommunityproject.model.ChatMsg
import com.example.mincommunityproject.model.MsgItemModel

/**
 *Created by ming on 2024/6/25.
 */
class ChatItemAdapter(private val list: List<ChatMsg>) :
    RecyclerView.Adapter<ChatItemAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ChatMsgItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatItemAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ChatMsgItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val msg = list[position]
        with(holder.binding) {
            if (msg.type == ChatMsg.TYPE_RECEIVED) {
                // 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
                chatItemLeftLayout.visibility = View.VISIBLE
                chatItemLeftMsg.text = msg.content

                // 隐藏右面的消息布局
                chatItemRightLayout.visibility = View.GONE
            } else if (msg.type == ChatMsg.TYPE_SEND) {
                // 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
                chatItemRightLayout.visibility = View.VISIBLE
                chatItemRightMsg.text = msg.content

                // 隐藏左面的消息布局
                chatItemLeftLayout.visibility = View.GONE
            }
        }
    }

    override fun getItemCount() = list.size

}