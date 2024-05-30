package com.example.mincommunityproject.model

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
