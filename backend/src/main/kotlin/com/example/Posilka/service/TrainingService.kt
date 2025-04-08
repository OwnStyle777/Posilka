package com.example.Posilka.service

import com.example.Posilka.dto.TrainingDto
import com.example.Posilka.dto.mappers.TrainingMapper
import com.example.Posilka.model.Training
import com.example.Posilka.repository.TrainingRepository
import org.springframework.stereotype.Service

@Service
class TrainingService(val trainingRepository: TrainingRepository, val trainingMapper: TrainingMapper) {

    fun findById(id: Long): Training {
        return trainingRepository.findById(id).orElseThrow {
            IllegalArgumentException("Training with id $id doesn't exist")
        }
    }

    fun findDtoById(id: Long): TrainingDto {
       val training =trainingRepository.findById(id).orElseThrow {
            IllegalArgumentException("Training with id $id doesn't exist")
        }
        return trainingMapper.toDto(training);
    }

    fun findAll(): List<TrainingDto> {
        val trainings = trainingRepository.findAll()
    return trainings.map { trainingMapper.toDto(it) }}


    fun save(training: TrainingDto): TrainingDto{
        val savedTraining = trainingRepository.save(trainingMapper.toEntity(training))
    return trainingMapper.toDto(savedTraining)}

    fun deleteById(id: Long) = trainingRepository.deleteById(id)

    fun update(id: Long, trainingDto: TrainingDto): TrainingDto {
        val existingTraining = trainingRepository.findById(id).orElseThrow {
            IllegalArgumentException("Training with id $id doesn't exist")
        }
        val updatedTraining = trainingMapper.updateEntity(trainingDto, existingTraining)
        val savedTraining = trainingRepository.save(updatedTraining)
        return trainingMapper.toDto(savedTraining)
    }
}