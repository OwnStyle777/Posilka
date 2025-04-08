package com.example.Posilka.dto

import com.example.Posilka.model.Training

data class ExerciseDto (
    val id: Long? = null,
    val name: String,
    val series: List<SeriesDto> = listOf(),
    val history: List<HistoryDto> = listOf(),
    val trainingTemplateId: Long? = null,
    val trainingId: Long? = null,
    val instructions: String,
    val muscleGroup: String,
    val difficulty: String,
    val muscles: String,
    val pr: String? = null,
    val mediaUrl: String? = null,
)
