package com.example.Posilka.dto

data class SeriesDto (
    val id: Long? = null,
    val setNumber: Int,
    val reps: Int,
    val kg: Int,
    val completed: Boolean,
    val exerciseId: Long,
)