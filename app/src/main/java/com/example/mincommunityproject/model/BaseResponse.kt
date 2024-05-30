package com.example.mincommunityproject.model

import java.sql.Timestamp

data class BaseResponse(
    val timestamp: Timestamp,
    val status: Int,
    val msg: String,
    val `data`: List<Any>
)
