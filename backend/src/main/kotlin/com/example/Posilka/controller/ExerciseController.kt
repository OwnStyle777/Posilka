package com.example.Posilka.controller

import com.example.Posilka.dto.ExerciseDto
import com.example.Posilka.service.ExerciseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exercises")
class ExerciseController (private val exerciseService: ExerciseService){

    @GetMapping("/{id}")
    fun getExerciseById(@PathVariable id: Long): ResponseEntity<ExerciseDto> {
        val exerciseDto = exerciseService.findById(id)
        return ResponseEntity.ok(exerciseDto)
    }

    @GetMapping("/getAll")
    fun getAllExercises(): ResponseEntity<List<ExerciseDto>> {
        val exerciseDtos = exerciseService.findAll()
        return ResponseEntity.ok(exerciseDtos)
    }

    @PostMapping("/create")
    fun createExercise(@RequestBody exerciseDto: ExerciseDto): ResponseEntity<ExerciseDto> {
        val createdExerciseDto = exerciseService.save(exerciseDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExerciseDto)
    }

    @PutMapping("/{id}")
    fun updateExercise(@PathVariable id: Long, @RequestBody exerciseDto: ExerciseDto): ResponseEntity<ExerciseDto> {
        val updatedExerciseDto = exerciseService.update(id, exerciseDto)
        return ResponseEntity.ok(updatedExerciseDto)
    }

    @DeleteMapping("/{id}")
    fun deleteExercise(@PathVariable id: Long): ResponseEntity<Void> {
        exerciseService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/training/{trainingId}")
    fun getExercisesByTrainingId(@PathVariable trainingId: Long): ResponseEntity<List<ExerciseDto>> {
        val exerciseDtos = exerciseService.findByTrainingId(trainingId)
        return ResponseEntity.ok(exerciseDtos)
    }

    @GetMapping("/template/{trainingTemplateId}")
    fun getExercisesByTrainingTemplateId(@PathVariable trainingTemplateId: Long): ResponseEntity<List<ExerciseDto>> {
        val exerciseDtos = exerciseService.findByTrainingTemplateId(trainingTemplateId)
        return ResponseEntity.ok(exerciseDtos)
    }
}