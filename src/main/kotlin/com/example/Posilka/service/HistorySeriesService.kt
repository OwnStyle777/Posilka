package com.example.Posilka.service

import com.example.Posilka.model.HistorySeries
import com.example.Posilka.repository.HistorySeriesRepository
import org.springframework.stereotype.Service

@Service
class HistorySeriesService(val historySeriesRepository: HistorySeriesRepository) {
    fun findById(id: Long): HistorySeries {
        return historySeriesRepository.findById(id).orElseThrow {
            IllegalArgumentException("History series with id $id doesn't exist")
        }
    }

    fun findAll(): List<HistorySeries> = historySeriesRepository.findAll()

    fun save(historySeries: HistorySeries): HistorySeries = historySeriesRepository.save(historySeries)

    fun deleteById(id: Long) = historySeriesRepository.deleteById(id)

    fun findByHistoryId(id: Long) = historySeriesRepository.findByHistoryId(id)
}