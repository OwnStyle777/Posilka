package com.example.Posilka.repository

import com.example.Posilka.model.Exercise
import com.example.Posilka.model.TrainingTemplate
import org.springframework.data.jpa.repository.JpaRepository

interface TrainingTemplateRepository : JpaRepository<TrainingTemplate, Long> {
    fun findByTrainingId(trainingId: Long): List<TrainingTemplate>
}