package com.example.Posilka.dto.mappers

import com.example.Posilka.dto.HistorySeriesDto
import com.example.Posilka.dto.SeriesDto
import com.example.Posilka.model.Series
import com.example.Posilka.service.ExerciseService
import org.springframework.stereotype.Component

@Component
class SeriesMapper (private val exerciseService: ExerciseService){

    fun toDto(series: Series): SeriesDto {
        return SeriesDto(
            id = series.id,
            setNumber = series.setNumber,
            reps = series.reps,
            kg = series.kg,
            completed = series.completed,
            exerciseId = series.exercise.id
        )
    }

    fun toEntity(dto: SeriesDto): Series {
        return Series(
            setNumber = dto.setNumber,
            reps = dto.reps,
            kg = dto.kg,
            completed = dto.completed,
            exercise = exerciseService.findEntityById(dto.exerciseId)
        )
    }

    fun updateEntity(dto: SeriesDto, existing: Series): Series {
        val updatedExercise = if (dto.exerciseId != 0L) exerciseService.findEntityById(dto.exerciseId) else existing.exercise
        return existing.copy(
            setNumber = if (dto.setNumber != 0 ) dto.setNumber else existing.setNumber,
            reps = if (dto.reps != 0 ) dto.reps else existing.reps,
            kg = if (dto.kg != 0) dto.kg else existing.kg,
            completed = dto.completed,
            exercise = updatedExercise
        )
    }
}