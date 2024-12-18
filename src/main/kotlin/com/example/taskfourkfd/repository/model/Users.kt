package com.example.taskfourkfd.repository.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table
data class Users (
    @Id
    val uid: UUID,

    @Column(nullable = false)
    val login: String,

    @Column(nullable = false)
    val password: String,

)