package com.example.mincommunityproject.model

/**
 *Created by ming on 2024/6/24.
 */
data class ChatMessage(
    val context: String,
    val sender: String,
    val timestamp: Long
)