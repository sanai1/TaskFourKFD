package com.example.taskfourkfd.service

import com.example.taskfourkfd.exception.TransactionNotFoundException
import com.example.taskfourkfd.repository.Repository
import com.example.taskfourkfd.repository.model.Transactions
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService (private val transactionRepository: Repository) {

    // получаем список всех задач
    fun findAllTransactions(): List<Transactions> = transactionRepository.findAll()

    // получаем задачу по transactionId
    fun getTransactionById(transactionId: Long): Optional<Transactions> = transactionRepository.findById(transactionId)
        ?: throw TransactionNotFoundException(HttpStatus.NOT_FOUND, "Транзакция $transactionId не найдена")

    // создаем транзакцию
    fun createTransaction(transaction: Transactions): Transactions = transactionRepository.save(transaction)

    // обновляем транзакцию, если она найдена, иначе выбрасываем исключение
    fun updateTransaction(transactionId: Long, transaction: Transactions): Transactions {
        return if (transactionRepository.existsById(transactionId)) {
            transactionRepository.save(
                Transactions(
                    id = transaction.id,
//                    data = transaction.data,
                    sale = transaction.sale,
                    purchase = transaction.purchase
                )
            )
        } else throw TransactionNotFoundException(HttpStatus.NOT_FOUND, "Транзакция с $transactionId не найдена")
    }

    // удаляем транзакцию
    fun deleteTransactionById(transactionId: Long) {
        return if (transactionRepository.existsById(transactionId)) {
            transactionRepository.deleteById(transactionId)
        } else throw TransactionNotFoundException(HttpStatus.NOT_FOUND, "Транзакция с $transactionId не найдена")
    }

}