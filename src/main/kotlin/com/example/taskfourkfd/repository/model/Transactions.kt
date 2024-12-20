package com.example.taskfourkfd.repository.model

import com.example.taskfourkfd.repository.model.view.ViewTransactions
import jakarta.persistence.*

@Entity
@Table
data class Transactions(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: Users,

    @Column(nullable = false)
    val sale: Long,


    @Column(nullable = false)
    val purchase: Long,

) {
    fun fromTransaction(): ViewTransactions =
        ViewTransactions(
            id = id,
            user_uid = user.uid,
            sale = sale,
            purchase = purchase
        )
}
