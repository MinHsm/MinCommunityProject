package com.example.mincommunityproject.model
/**
 * 登录接口返回的model
 * @author Min
 * @time 2024/6/2 20:12
 */
data class LoginResponse(
    val timestamp: Long,
    val status: String,
    val message: String,
    val data: Data
)

