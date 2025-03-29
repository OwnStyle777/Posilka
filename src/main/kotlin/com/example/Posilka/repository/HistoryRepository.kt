package com.example.Posilka.repository

import com.example.Posilka.model.History
import org.springframework.data.jpa.repository.JpaRepository

interface HistoryRepository : JpaRepository<History, Long> {
}