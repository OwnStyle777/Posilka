package com.example.Posilka.model

import jakarta.persistence.*

@Entity
@Table(name = "series")
data class Series(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column()
    var setNumber: Int = 0,

    @Column()
    var reps: Int = 0,

    @Column()
    var kg: Int = 0,

    @Column()
    var completed: Boolean = false,

    )
