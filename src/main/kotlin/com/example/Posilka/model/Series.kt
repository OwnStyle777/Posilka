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
@Table(name = "series")
data class Series(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,

    @Column
    var setNumber: Int = 0,

    @Column
    var reps: Int = 0,

    @Column
    var kg: Int = 0,

    @Column
    var completed: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    var exercise: Exercise

)
