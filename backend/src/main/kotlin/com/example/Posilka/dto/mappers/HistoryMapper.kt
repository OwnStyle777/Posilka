package com.example.Posilka.dto.mappers

import com.example.Posilka.dto.HistoryDto
import com.example.Posilka.model.History
import com.example.Posilka.service.ExerciseService
import org.springframework.stereotype.Component

@Component
class HistoryMapper(private val exerciseService: ExerciseService, private val historySeriesMapper: HistorySeriesMapper) {

    fun toDto(history: History): HistoryDto {
        return HistoryDto(
            id = history.id,
            date = history.date,
            exerciseId = history.exercise.id,
            series = history.series.map { historySeriesMapper.toDto(it) }
        )
    }

    fun toEntity(dto: HistoryDto): History {
        return History(
            date = dto.date,
            exercise = exerciseService.findEntityById(dto.exerciseId),
            series = dto.series.map { historySeriesMapper.toEntity(it) }.toMutableList()
        )
    }

    fun updateEntity(dto: HistoryDto, existing: History): History {
        return existing.copy(
            date = dto.date.takeIf { it != existing.date } ?: existing.date,
            exercise = exerciseService.findEntityById(dto.exerciseId),
            series = dto.series.mapNotNull { seriesDto ->
                val existingSeries = existing.series.find { it.id == seriesDto.id }
                existingSeries?.let { historySeriesMapper.updateEntity(seriesDto, it) }
            }.toMutableList()
        )
    }
}