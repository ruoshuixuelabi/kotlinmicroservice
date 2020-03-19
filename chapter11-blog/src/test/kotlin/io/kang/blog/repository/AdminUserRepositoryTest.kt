package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.QAdminUser
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@ExtendWith(SpringExtension::class)
class AdminUserRepositoryTest  {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    @Test
    @Order(1)
    fun testCreateIndex() {
        val qAdminUser = QAdminUser.adminUser
        val userName = "admin"
        val password = "e10adc3949ba59abbe56e057f20f883e"
        val user = queryFactory.selectFrom(qAdminUser)
                .where(qAdminUser.loginUserName.eq(userName).and(qAdminUser.loginPassword.eq(password)))
                .fetchOne()
        println(user)
    }
}