package com.example.mincommunityproject.model

data class LoginResponse(
    val timestamp: Long,
    val status: String,
    val message: String,
    val data: Data
)

