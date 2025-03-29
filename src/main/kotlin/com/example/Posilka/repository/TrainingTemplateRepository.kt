package com.example.Posilka.repository

import com.example.Posilka.model.TrainingTemplate
import org.springframework.data.jpa.repository.JpaRepository

interface TrainingTemplateRepository : JpaRepository<TrainingTemplate, Long> {
}