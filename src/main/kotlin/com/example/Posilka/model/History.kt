package com.example.Posilka.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "exercises")
data class History(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

)
