package com.example.mincommunityproject.model
/**
 * 登录接口返回数据model
 * @author Min
 * @time 2024/6/2 20:06
 */
data class Customer(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String?,
    val birth: String,
    val idNumber: String,
    val areaId: Int,
    val stateId: Int
)
