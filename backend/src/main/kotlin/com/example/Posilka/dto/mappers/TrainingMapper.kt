package com.example.Posilka.dto.mappers

import com.example.Posilka.dto.TrainingDto
import com.example.Posilka.model.Training
import org.springframework.stereotype.Component

@Component
class TrainingMapper  {

    fun toDto(entity: Training): TrainingDto {
        return TrainingDto(
            id = entity.id,
            name = entity.name,
            dateFrom = entity.dateFrom,
            dateTo = entity.dateTo,
            duration = entity.duration,
        )
    }

    fun toEntity(dto: TrainingDto): Training {
        return Training(
            name = dto.name,
            dateFrom = dto.dateFrom,
            dateTo = dto.dateTo,
            duration = dto.duration
        )
    }

    fun updateEntity(dto: TrainingDto, existingEntity: Training): Training {
        return existingEntity.copy(
            name = dto.name.takeIf { it.isNotEmpty() } ?: existingEntity.name,
            dateFrom = dto.dateFrom,
            dateTo = dto.dateTo,
            duration = dto.duration,

        )
    }

}