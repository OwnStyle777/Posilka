package com.example.Posilka.dto.mappers

import com.example.Posilka.dto.ExerciseDto
import com.example.Posilka.model.Exercise
import com.example.Posilka.service.TrainingService
import com.example.Posilka.service.TrainingTemplateService
import org.springframework.stereotype.Component

@Component
class ExerciseMapper ( val trainingTemplateService: TrainingTemplateService, val trainingService: TrainingService){

    fun toDto(entity: Exercise): ExerciseDto {
        return ExerciseDto(
            id = entity.id,
            name = entity.name,
            trainingTemplateId = entity.trainingTemplate?.id,
            trainingId = entity.training?.id,
            instructions = entity.instructions,
            muscleGroup = entity.muscleGroup,
            difficulty = entity.difficulty,
            muscles = entity.muscles,
            pr = entity.pr,
            mediaUrl = entity.mediaUrl
        )
    }

    fun toEntity(dto: ExerciseDto): Exercise {
        return Exercise(
            name = dto.name,
            trainingTemplate = dto.trainingTemplateId?.let { trainingTemplateService.findById(it) },
            training = dto.trainingId?.let { trainingService.findById(it) },
            instructions = dto.instructions,
            muscleGroup = dto.muscleGroup,
            difficulty = dto.difficulty,
            muscles = dto.muscles,
            pr = dto.pr,
            mediaUrl = dto.mediaUrl
        )
    }

    fun updateEntity(dto: ExerciseDto, existingEntity: Exercise): Exercise {
        return existingEntity.copy(
            name = dto.name.takeIf { it.isNotEmpty() } ?: existingEntity.name,
            trainingTemplate = dto.trainingTemplateId?.let { trainingTemplateService.findById(it) } ?: existingEntity.trainingTemplate,
            training = dto.trainingId?.let { trainingService.findById(it) } ?: existingEntity.training,
            instructions = dto.instructions.takeIf { it.isNotEmpty() } ?: existingEntity.instructions,
            muscleGroup = dto.muscleGroup.takeIf { it.isNotEmpty() } ?: existingEntity.muscleGroup,
            difficulty = dto.difficulty.takeIf { it.isNotEmpty() } ?: existingEntity.difficulty,
            muscles = dto.muscles.takeIf { it.isNotEmpty() } ?: existingEntity.muscles,
            pr = dto.pr ?: existingEntity.pr,
            mediaUrl = dto.mediaUrl ?: existingEntity.mediaUrl
        )
    }


}