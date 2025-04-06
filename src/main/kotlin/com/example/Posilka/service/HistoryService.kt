package com.example.Posilka.service

import com.example.Posilka.model.History
import com.example.Posilka.repository.HistoryRepository
import org.springframework.stereotype.Service

@Service
class HistoryService(val historyRepository: HistoryRepository) {
    fun findById(id: Long): History {
        return historyRepository.findById(id).orElseThrow {
            IllegalArgumentException("History with id $id doesn't exist")
        }
    }

    fun findAll(): List<History> = historyRepository.findAll()

    fun save(history: History): History = historyRepository.save(history)

    fun deleteById(id: Long) = historyRepository.deleteById(id)
}