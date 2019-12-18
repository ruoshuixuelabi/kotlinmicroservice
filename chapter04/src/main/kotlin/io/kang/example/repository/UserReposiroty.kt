package io.kang.example.repository

import io.kang.example.entity.User
import org.springframework.data.repository.CrudRepository

interface UserReposiroty: CrudRepository<User, Long> {
    fun findByUserNameAndPassword(userName: String, password: String): User?

    fun findByUserNameLike(userName: String): List<User>?

    fun findByIncomeGreaterThan(income: Double): List<User>?

    fun findByUserNameContains(userName: String): List<User>?

    fun deleteByUserNameAndEmail(userName: String, email: String): Int?

    fun save(use: User)
}