package com.example.Posilka.dto.mappers

import com.example.Posilka.dto.TrainingTemplateDto
import com.example.Posilka.model.TrainingTemplate
import com.example.Posilka.service.TrainingService
import org.springframework.stereotype.Component

@Component
class TrainingTemplateMapper(val exerciseMapper: ExerciseMapper, val trainingService: TrainingService) {

    fun toDto(entity: TrainingTemplate): TrainingTemplateDto {
        return TrainingTemplateDto(
            id = entity.id,
            name = entity.name,
            trainingId = entity.training?.id ?: 0L
        )
    }

    fun toEntity(dto: TrainingTemplateDto): TrainingTemplate {
        return TrainingTemplate(
            name = dto.name,
            training = dto.trainingId.let { trainingService.findById(it) },
        )
    }

    fun updateEntity(dto: TrainingTemplateDto, existingEntity: TrainingTemplate): TrainingTemplate {
        return existingEntity.copy(
            name = dto.name.takeIf { it.isNotEmpty() } ?: existingEntity.name,
            training = dto.trainingId.let { trainingService.findById(it) },

        )
    }
}