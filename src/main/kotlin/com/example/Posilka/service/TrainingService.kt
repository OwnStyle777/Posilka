package com.example.Posilka.service

import com.example.Posilka.model.Training
import com.example.Posilka.repository.TrainingRepository
import org.springframework.stereotype.Service

@Service
class TrainingService(val trainingRepository: TrainingRepository) {

    fun findById(id: Long): Training {
        return trainingRepository.findById(id).orElseThrow {
            IllegalArgumentException("Training with id $id doesn't exist")
        }
    }

    fun findAll(): List<Training> = trainingRepository.findAll()

    fun save(training: Training): Training= trainingRepository.save(training)

    fun deleteById(id: Long) = trainingRepository.deleteById(id)
}