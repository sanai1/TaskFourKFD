package com.example.taskfourkfd.controller

import com.example.taskfourkfd.repository.model.Transactions
import com.example.taskfourkfd.service.TransactionService
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(private val transactionService: TransactionService) {

    @GetMapping
    fun getAllTransactions(): List<Transactions> = transactionService.findAllTransactions()

    @GetMapping("/{id}")
    fun getTransactionById(@PathVariable("id") transactionId: Long): Optional<Transactions> =
        transactionService.getTransactionById(transactionId)

    @PostMapping
    fun createTransaction(@RequestBody transaction: Transactions): Transactions =
        transactionService.createTransaction(transaction)

    @PutMapping("/{id}")
    fun updateTransactionById(@PathVariable("id") transactionId: Long, @RequestBody transaction: Transactions): Transactions =
        transactionService.updateTransaction(transactionId, transaction)

    @DeleteMapping("/{id}")
    fun deleteTransactionById(@PathVariable("id") transactionId: Long) =
        transactionService.deleteTransactionById(transactionId)
}