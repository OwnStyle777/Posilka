package com.example.Posilka.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.time.LocalTime


@Entity
@Table(name = "training")
data class Training(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    var name: String,

    @OneToMany(mappedBy = "training", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var exercises: List<Exercise> = emptyList(),

    @OneToMany(mappedBy = "training", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var trainingTemplates: List<TrainingTemplate> = emptyList(),

    @Column
    val dateFrom: LocalDateTime,
    @Column
    val dateTo: LocalDateTime,

    @Column(nullable = false)
    val duration: LocalTime

)
