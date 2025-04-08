package com.example.Posilka.dto

import java.time.LocalDateTime
import java.time.LocalTime

data class TrainingDto (
    val id: Long? = null,
    val name: String,
    val exercises: List<ExerciseDto> = listOf(),
    val trainingTemplates: List<TrainingTemplateDto> = listOf(),
    val dateFrom: LocalDateTime,
    val dateTo: LocalDateTime,
    val duration: LocalTime
)