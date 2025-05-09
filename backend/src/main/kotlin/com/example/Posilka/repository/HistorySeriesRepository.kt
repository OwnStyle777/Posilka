package com.example.Posilka.repository

import com.example.Posilka.model.History
import com.example.Posilka.model.HistorySeries
import org.springframework.data.jpa.repository.JpaRepository

interface HistorySeriesRepository: JpaRepository<HistorySeries, Long> {
    fun findByHistoryId (historyId: Long): List<HistorySeries>
}