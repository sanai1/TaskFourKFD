package com.example.taskfourkfd.service

import com.example.taskfourkfd.repository.dao.TransactionsDao
import com.example.taskfourkfd.repository.dao.UsersDao
import com.example.taskfourkfd.repository.model.Transactions
import com.example.taskfourkfd.repository.model.Users
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService (private val usersRepository: UsersDao, private val transactionsDao: TransactionsDao) {

    fun findAllUsers(): List<Users> = usersRepository.findAll()

    fun getUserById(userId: UUID): Users? = usersRepository.findByIdOrNull(userId)

    fun createUser(user: Users): Users = usersRepository.save(user)

    fun createTransaction(userId: UUID, sale: Long, purchase: Long): Transactions? {
        val user = usersRepository.findById(userId).orElse(null)
        return if (user != null) {
            transactionsDao.save(
                Transactions(
                    user = user,
                    sale = sale,
                    purchase = purchase
                ))
        } else user
    }

    fun getUserTransactions(userId: UUID): List<Transactions> {
        val user = usersRepository.findById(userId).orElse(null)
        return if (user != null) {
            transactionsDao.findByUser(user)
        } else emptyList()
    }

}