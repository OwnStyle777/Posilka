package com.example.Posilka.dto

data class HistorySeriesDto (
    val id: Long? = null,
    val reps: Int,
    val kg: Int,
    val setNumber: Int,
    val completed: Boolean,
    val historyId: Long
)