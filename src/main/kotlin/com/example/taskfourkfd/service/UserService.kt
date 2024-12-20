package com.example.taskfourkfd.service

import com.example.taskfourkfd.repository.dao.TransactionsDao
import com.example.taskfourkfd.repository.dao.UsersDao
import com.example.taskfourkfd.repository.model.Users
import com.example.taskfourkfd.repository.model.view.ViewTransactions
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService (private val usersRepository: UsersDao, private val transactionsDao: TransactionsDao) {

    fun findAllUsers(): List<Users> = usersRepository.findAll()

    fun getUserById(userId: UUID): Users? = usersRepository.findByIdOrNull(userId)

    fun createUser(user: Users): Users = usersRepository.save(user)

    fun createTransaction(viewTransactions: ViewTransactions): ViewTransactions? {
        val user = usersRepository.findByIdOrNull(viewTransactions.user_uid)
        return if (user != null) {
            transactionsDao.save(
                viewTransactions.toTransaction(user)
            )
            viewTransactions
        } else null
    }

    fun getUserTransactions(userId: UUID): List<ViewTransactions> {
        val user = usersRepository.findById(userId).orElse(null)
        return if (user != null) {
            val listPseudoTransactions: MutableList<ViewTransactions> = emptyList<ViewTransactions>().toMutableList()
            transactionsDao.findByUser(user).forEach { listPseudoTransactions.add(it.fromTransaction()) }
            listPseudoTransactions
        } else emptyList()
    }

}