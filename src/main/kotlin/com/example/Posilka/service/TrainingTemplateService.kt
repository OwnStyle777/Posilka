package com.example.Posilka.service

import com.example.Posilka.model.Exercise
import com.example.Posilka.model.TrainingTemplate
import com.example.Posilka.repository.TrainingTemplateRepository
import org.springframework.stereotype.Service

@Service
class TrainingTemplateService (private val trainingTemplateRepository: TrainingTemplateRepository) {

    fun findById(id: Long): TrainingTemplate {
        return trainingTemplateRepository.findById(id).orElseThrow {
            IllegalArgumentException("TrainingTemplate with id $id doesn't exist")
        }
    }

    fun findAll(): List<TrainingTemplate> = trainingTemplateRepository.findAll()

    fun save(trainingTemplate: TrainingTemplate): TrainingTemplate = trainingTemplateRepository.save(trainingTemplate)

    fun deleteById(id: Long) = trainingTemplateRepository.deleteById(id)
}