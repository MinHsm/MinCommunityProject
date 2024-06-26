package com.example.mincommunityproject.model

/**
 *Created by ming on 2024/6/25.
 */
data class ChatMsg(val content: String, val type: Int) {
    companion object {
        //表示这是一条收到的消息
        const val TYPE_RECEIVED = 0
        //表示这是一条发出的消息
        const val TYPE_SEND = 1
    }
}
