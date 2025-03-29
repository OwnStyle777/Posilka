package com.example.Posilka.model

import com.example.Posilka.model.Enums.MuscleGroup
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.Table
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
@Table(name = "exercise")
class Exercise (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val name: String,

    @OneToMany(mappedBy = "exercise", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var series: MutableList<Series> = mutableListOf(),

    @OneToMany(mappedBy = "exercise", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var history: MutableList<History> = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "training_template_id")
    var trainingTemplate: TrainingTemplate? = null,

    @ManyToOne
    @JoinColumn(name = "training_id")
    var training: Training? = null,

    @Column(columnDefinition = "TEXT")
    val instructions: String,

    @Column(nullable = false)
    val muscleGroup: String,

    @Column(nullable = false)
    val difficulty: String,

    @Column(nullable = false)
    val muscles: String,

    @Column
    var pr: String? = null,

    @Column
    val mediaUrl: String? = null

)