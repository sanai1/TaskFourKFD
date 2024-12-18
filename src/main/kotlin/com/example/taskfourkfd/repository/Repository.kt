package com.example.taskfourkfd.repository

import com.example.taskfourkfd.repository.model.Transactions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Repository : JpaRepository<Transactions, Long>