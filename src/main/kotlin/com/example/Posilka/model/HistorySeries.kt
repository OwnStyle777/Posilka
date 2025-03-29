package com.example.Posilka.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "historic_series")
data class HistorySeries(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,

    @Column(nullable = false)
    var setNumber: Int,

    @Column(nullable = false)
    var reps: Int,

    @Column(nullable = false)
    var kg: Int,

    @Column(nullable = false)
    var completed: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "history_id")
    var history: History
)
