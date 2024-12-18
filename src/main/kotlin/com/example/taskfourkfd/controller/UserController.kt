package com.example.taskfourkfd.controller

import com.example.taskfourkfd.repository.model.Transactions
import com.example.taskfourkfd.repository.model.Users
import com.example.taskfourkfd.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("api/v1/users")
class UserController (private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): List<Users> = userService.findAllUsers()

    @GetMapping("/{user_id}")
    fun getUserById(@PathVariable("user_id") userId: UUID): Users? =
        userService.getUserById(userId)

    @GetMapping("/{user_id}/transactions")
    fun getTransactions(@PathVariable("user_id") userId: UUID):  List<Transactions> =
        userService.getUserTransactions(userId)

    @PostMapping("/{user_id}/transactions")
    fun createUserTransaction(
        @PathVariable("user_id") userId: UUID,
        @RequestParam sale: Long,
        @RequestParam purchase: Long)
        : Transactions? = userService.createTransaction(userId, sale, purchase)

    @PostMapping
    fun createUser(@RequestBody user: Users): Users = userService.createUser(user)

}