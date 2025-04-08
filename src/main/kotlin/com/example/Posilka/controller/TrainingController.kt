package com.example.Posilka.controller

import com.example.Posilka.dto.TrainingDto
import com.example.Posilka.service.TrainingService
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
@RequestMapping("/api/trainings")
class TrainingController (private val trainingService: TrainingService){

    @GetMapping("/{id}")
    fun getTrainingById(@PathVariable id: Long): ResponseEntity<TrainingDto> {
        val trainingDto = trainingService.findDtoById(id)
        return ResponseEntity.ok(trainingDto)
    }

    @GetMapping
    fun getAllTrainings(): ResponseEntity<List<TrainingDto>> {
        val trainingDtos = trainingService.findAll()
        return ResponseEntity.ok(trainingDtos)
    }

    @PostMapping
    fun createTraining(@RequestBody trainingDto: TrainingDto): ResponseEntity<TrainingDto> {
        val createdTrainingDto = trainingService.save(trainingDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrainingDto)
    }

    @PutMapping("/{id}")
    fun updateTraining(@PathVariable id: Long, @RequestBody trainingDto: TrainingDto): ResponseEntity<TrainingDto> {
        val updatedTrainingDto = trainingService.update(id, trainingDto)
        return ResponseEntity.ok(updatedTrainingDto)
    }

    @DeleteMapping("/{id}")
    fun deleteTraining(@PathVariable id: Long): ResponseEntity<Void> {
        trainingService.deleteById(id)
        return ResponseEntity.noContent().build()
    }


}