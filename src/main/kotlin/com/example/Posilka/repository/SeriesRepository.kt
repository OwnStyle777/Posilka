package com.example.Posilka.repository

import com.example.Posilka.model.Series
import org.springframework.data.jpa.repository.JpaRepository

interface SeriesRepository : JpaRepository<Series, Long> {
    fun findByExerciseId (exerciseId: Long): List<Series>
}