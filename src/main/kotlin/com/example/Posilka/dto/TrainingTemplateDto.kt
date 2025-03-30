package com.example.Posilka.dto

data class TrainingTemplateDto (
    val id: Long? = null,
    val name: String,
    val exercises: List<ExerciseDto> = listOf(),
    val trainingId: Long,
)