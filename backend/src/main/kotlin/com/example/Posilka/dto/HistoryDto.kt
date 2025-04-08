package com.example.Posilka.dto

import com.example.Posilka.model.HistorySeries
import java.time.LocalDateTime

data class HistoryDto(
    val id: Long? = null,
    val date: LocalDateTime,
    val exerciseId: Long,
    val series: List<HistorySeriesDto> = listOf(),

    )
