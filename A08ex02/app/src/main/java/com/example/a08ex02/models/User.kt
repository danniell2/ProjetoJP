package com.example.a08ex02.models

// controller
// models
data class User(val name: Name, val email: String, val phone: String)
data class Name(val title: String, val first: String, val last: String)
data class UserResponse(val results: List<User>)

