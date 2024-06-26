package com.example.mincommunityproject.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mincommunityproject.R
import com.example.mincommunityproject.databinding.ActivityChatBinding
import com.example.mincommunityproject.model.ChatMsg
import com.example.mincommunityproject.ui.Adapter.ChatItemAdapter

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private val msgList = mutableListOf<ChatMsg>()
    private lateinit var adapter: ChatItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //设置顶部颜色
        val window: Window = this@ChatActivity.window
        window.statusBarColor = ContextCompat.getColor(this@ChatActivity, R.color.blue)

        adapter = ChatItemAdapter(msgList)
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.chatRecyclerView.adapter = adapter

        binding.apply {
            chatBtnBack.setOnClickListener {
                onBackPressed()
            }
        }

        //初始化消息列表
        msgList.add(ChatMsg("Hello", ChatMsg.TYPE_RECEIVED))

        binding.chatBtnSend.setOnClickListener {
            val content = binding.chatEtInput.text.toString()
            if (content.isNotEmpty()) {
                msgList.add(ChatMsg(content, ChatMsg.TYPE_SEND))
                adapter.notifyItemInserted(msgList.size - 1)
                binding.chatRecyclerView.scrollToPosition(msgList.size - 1)
                binding.chatEtInput.setText("")

                if (msgList.size == 2) {
                    msgList.add(ChatMsg("what's your name?", ChatMsg.TYPE_RECEIVED))
                    adapter.notifyItemInserted(msgList.size - 1)
                    binding.chatRecyclerView.scrollToPosition(msgList.size - 1)
                }
                if (msgList.size == 4) {
                    msgList.add(ChatMsg("Bye!", ChatMsg.TYPE_RECEIVED))
                    adapter.notifyItemInserted(msgList.size - 1)
                    binding.chatRecyclerView.scrollToPosition(msgList.size - 1)
                }
            }
        }
    }
}