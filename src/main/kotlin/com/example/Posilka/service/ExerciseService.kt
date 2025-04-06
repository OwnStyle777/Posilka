package com.example.Posilka.service

import com.example.Posilka.model.Exercise
import com.example.Posilka.repository.ExerciseRepository
import org.springframework.stereotype.Service

@Service
class ExerciseService(private val exerciseRepository: ExerciseRepository) {

    fun findById(id: Long): Exercise {
        return exerciseRepository.findById(id).orElseThrow {
            IllegalArgumentException("Exercise with id $id doesn't exist")
        }
    }

    fun findAll(): List<Exercise> = exerciseRepository.findAll()

    fun save(exercise: Exercise): Exercise = exerciseRepository.save(exercise)

    fun deleteById(id: Long) = exerciseRepository.deleteById(id)
}