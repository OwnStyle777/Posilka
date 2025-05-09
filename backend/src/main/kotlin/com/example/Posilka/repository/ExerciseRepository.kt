package com.example.Posilka.repository

import com.example.Posilka.model.Exercise
import com.example.Posilka.model.TrainingTemplate
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRepository :JpaRepository<Exercise, Long> {
    fun findByTrainingId(trainingId: Long): List<Exercise>
    fun findByTrainingTemplateId(trainingTemplateId: Long): List<Exercise>
}