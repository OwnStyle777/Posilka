package com.example.Posilka.repository

import com.example.Posilka.model.Training
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainingRepository : JpaRepository<Training, Long> {
    fun findByName(name: String): List<Training>
}