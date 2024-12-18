//package com.example.taskfourkfd.repository.model
//
//import jakarta.persistence.Column
//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import jakarta.persistence.ManyToMany
//import jakarta.persistence.ManyToOne
//import jakarta.persistence.Table
//import java.util.*
//
//@Entity
//@Table(name = "currency_pairs")
//data class CurrencyPairs(
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false, unique = true)
//    val id: Long = 0L,
//
//    @ManyToOne
//    @Column(nullable = false)
//    val currency_one: Currency,
//
//    @ManyToOne
//    @Column(nullable = false)
//    val currency_two: Currency,
//
//    )
