package io.kang.example.repository

import io.kang.example.entity.EducationLevel
import io.kang.example.entity.User
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class UserRepositoryTest {

    @Autowired
    lateinit var userReposiroty: UserReposiroty

    @Test
    fun testSaveUsers() {
        userReposiroty.deleteAll()
        var users = arrayOf(
                User(0, "test01", "test01", "test01@qq.com", 45, 175.5, "Shanghai", EducationLevel.BOSHI, 50000.0),
                User(1, "test02", "test02", "test02@qq.com", 36, 170.5, "Shanghai", EducationLevel.YANJIUSHENG, 20000.0),
                User(2, "test03", "test03", "test03@qq.com", 26, 165.5, "Shanghai", EducationLevel.YANJIUSHENG, 10000.0)
        )

        userReposiroty.saveAll(users.asList().asIterable())

        val users1 = userReposiroty.findAll()
        Assert.assertEquals(3, users1.toList().size)
    }

    @Test
    fun testFindAllUsers() {

    }

}