package com.example.Posilka.service

import com.example.Posilka.model.Series
import com.example.Posilka.repository.SeriesRepository
import org.springframework.stereotype.Service

@Service
class SeriesService (val seriesRepository: SeriesRepository){
    fun findById(id: Long): Series {
        return seriesRepository.findById(id).orElseThrow {
            IllegalArgumentException("Series with id $id doesn't exist")
        }
    }

    fun findAll(): List<Series> = seriesRepository.findAll()

    fun save(series: Series): Series = seriesRepository.save(series)

    fun deleteById(id: Long) = seriesRepository.deleteById(id)



}