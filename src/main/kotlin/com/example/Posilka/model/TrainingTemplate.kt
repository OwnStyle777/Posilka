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


@Entity
@Table(name = "training_template")
data class TrainingTemplate(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    var name: String,

    @OneToMany(mappedBy = "trainingTemplate", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @Column
    var exercises: List<Exercise> = emptyList(),

    @ManyToOne
    @JoinColumn(name = "training_id")
    @Column
    var training: Training? = null

)
