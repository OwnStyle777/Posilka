package com.example.Posilka.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "history")
data class History(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,

    val date: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    var exercise: Exercise,

    @OneToMany(mappedBy = "history", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var series: MutableList<HistorySeries> = mutableListOf()

)
