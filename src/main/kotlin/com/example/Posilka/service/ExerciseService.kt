package com.example.Posilka.service

import com.example.Posilka.dto.ExerciseDto
import com.example.Posilka.dto.mappers.ExerciseMapper
import com.example.Posilka.model.Exercise
import com.example.Posilka.repository.ExerciseRepository
import org.springframework.stereotype.Service

@Service
class ExerciseService(private val exerciseRepository: ExerciseRepository,  private val exerciseMapper: ExerciseMapper) {

    fun findById(id: Long): ExerciseDto {
        val exercise = exerciseRepository.findById(id).orElseThrow {
            IllegalArgumentException("Exercise with id $id doesn't exist")
        }
        return exerciseMapper.toDto(exercise)
    }

    fun findAll(): List<ExerciseDto> {
        val exercises = exerciseRepository.findAll()
        return exercises.map { exerciseMapper.toDto(it) }
    }

    fun save(exerciseDto: ExerciseDto): ExerciseDto {
        val exercise = exerciseMapper.toEntity(exerciseDto)
        val savedExercise = exerciseRepository.save(exercise)
        return exerciseMapper.toDto(savedExercise)
    }

    fun deleteById(id: Long) {
        val exercise = exerciseRepository.findById(id).orElseThrow {
            IllegalArgumentException("Exercise with id $id doesn't exist")
        }
        exerciseRepository.delete(exercise)
    }

    fun findByTrainingId(trainingId: Long): List<ExerciseDto> {
        val exercises = exerciseRepository.findByTrainingId(trainingId)
        return exercises.map { exerciseMapper.toDto(it) }
    }

    fun findByTrainingTemplateId(trainingTemplateId: Long): List<ExerciseDto> {
        val exercises = exerciseRepository.findByTrainingTemplateId(trainingTemplateId)
        return exercises.map { exerciseMapper.toDto(it) }
    }

    fun update(id: Long, exerciseDto: ExerciseDto): ExerciseDto {
        val existingExercise = exerciseRepository.findById(id).orElseThrow {
            IllegalArgumentException("Exercise with id $id doesn't exist")
        }
        val updatedExercise = exerciseMapper.updateEntity(exerciseDto, existingExercise)
        val savedExercise = exerciseRepository.save(updatedExercise)
        return exerciseMapper.toDto(savedExercise)
    }
}