package com.example.Posilka.dto.mappers

import com.example.Posilka.dto.HistorySeriesDto
import com.example.Posilka.model.HistorySeries
import com.example.Posilka.service.ExerciseService
import com.example.Posilka.service.HistoryService
import org.springframework.stereotype.Component

@Component
class HistorySeriesMapper(private val historyService: HistoryService){

    fun toDto(entity: HistorySeries): HistorySeriesDto {
        return HistorySeriesDto(
            id = entity.id,
            reps = entity.reps,
            kg = entity.kg,
            completed = entity.completed,
            setNumber = entity.setNumber,
            historyId = entity.history?.id ?: throw IllegalStateException("History cannot be null")
        )
    }

    fun toEntity(dto: HistorySeriesDto): HistorySeries {
        return HistorySeries(
            setNumber = dto.setNumber,
            reps = dto.reps,
            kg = dto.kg,
            completed = dto.completed,
            history = historyService.findById(dto.historyId)
        )
    }

    fun updateEntity(dto: HistorySeriesDto, existing: HistorySeries): HistorySeries {
        return existing.copy(
            setNumber = if (dto.setNumber != 0) dto.setNumber else existing.setNumber,
            reps = if (dto.reps != 0) dto.reps else existing.reps,
            kg = if (dto.kg != 0) dto.kg else existing.kg,
            completed = dto.completed,
            history = historyService.findById(dto.historyId)
        )
    }
}