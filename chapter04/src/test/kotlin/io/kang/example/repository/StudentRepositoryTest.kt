package io.kang.example.repository

import io.kang.example.entity.Student
import org.junit.Assert
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@ExtendWith(SpringExtension::class)
class StudentRepositoryTest {
    @Autowired
    lateinit var studentRepository: StudentRepository

    @Test
    @Order(1)
    fun saveStudents() {
        val student = Student("篮球","Kotlin编程","上海中学")
        student.personId = 20180101L
        student.age = 22
        student.name = "张三"

        studentRepository.deleteAll()

        for(i in 0..15) {
            student.age = 22 - i
            student.personId = 20180101L + i
            studentRepository.save(student)
        }
    }

    @Test
    @Order(2)
    fun testFindByNameAndAge() {
        val pageable = PageRequest.of(0, 5)

        val studentPage = studentRepository.findByNameRegexAndAgeGreaterThanEqual("张三", 20, pageable)

        Assert.assertEquals(3, studentPage.content.size)
    }

    @Test
    @Order(3)
    fun testFindByNameAndAge1() {
        val pageable = PageRequest.of(0, 5)
        val studentPage = studentRepository.findByAgeIndividual("张三", 10, pageable)
        Assert.assertEquals(5, studentPage.content.size)
    }

    @Test
    @Order(4)
    fun testDeleteByAgeGreaterThanAndAgeLessThan() {
        studentRepository.deleteByAgeIn(20, 22)
        val students = studentRepository.findAll()
        Assert.assertEquals(13, students.size)
    }
}