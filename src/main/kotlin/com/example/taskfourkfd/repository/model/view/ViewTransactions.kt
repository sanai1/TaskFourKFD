package com.example.taskfourkfd.repository.model.view

import com.example.taskfourkfd.repository.model.Transactions
import com.example.taskfourkfd.repository.model.Users
import java.util.UUID

data class ViewTransactions(
    val id: Long,
    val user_uid: UUID,
    val sale: Long,
    val purchase: Long
) {
    fun toTransaction(user: Users): Transactions =
        Transactions(
        user = user,
        sale = sale,
        purchase = purchase
        )
}