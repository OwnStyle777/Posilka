package com.example.Posilka.model

import com.example.Posilka.model.Enums.Difficulty
import com.example.Posilka.model.Enums.Muscle
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
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "exercises")
class Exercise (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val name: String,

    @OneToMany(mappedBy = "exercise", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var history: List<History> = emptyList(),

    @Column(columnDefinition = "TEXT")
    val instructions: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val muscleGroup: MuscleGroup,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val difficulty: Difficulty,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val muscle: List<Muscle> = emptyList(),

    var pr: String? = null,

    val mediaUrl: String? = null


)