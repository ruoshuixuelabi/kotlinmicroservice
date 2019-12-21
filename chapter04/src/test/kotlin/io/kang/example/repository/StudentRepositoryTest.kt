package io.kang.example.repository

import io.kang.example.entity.Student
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

        for(i in 0..15) {
            student.age = student.age - i
            student.personId = student.personId + i
            studentRepository.save(student)
        }
    }
}