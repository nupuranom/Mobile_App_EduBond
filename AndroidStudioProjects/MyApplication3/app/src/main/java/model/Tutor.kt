package com.example.myapplication.model


data class Tutor(
    val name: String,
    val subject: String,
    val rating: Float,
    val verified: Boolean,
    val imageResId: Int
)
