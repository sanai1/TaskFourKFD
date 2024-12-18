package com.example.taskfourkfd.repository.model

import jakarta.persistence.*

@Entity
@Table(name = "transactions")
data class Transactions(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0L,

    @Column(name = "sale", nullable = false)
    var sale: Long,

    @Column(name = "purchase", nullable = false)
    var purchase: Long,


)