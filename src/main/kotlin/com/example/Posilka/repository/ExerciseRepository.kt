package com.example.Posilka.repository

import com.example.Posilka.model.Exercise
import com.example.Posilka.model.Training
import com.example.Posilka.model.TrainingTemplate
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRepository :JpaRepository<Exercise, Long> {
    fun findByTraining(training: Training): List<Exercise>
    fun findByTrainingTemplate(trainingTemplate: TrainingTemplate): List<Exercise>
}