package io.kang.example.controller

import io.kang.example.entity.User
import org.springframework.security.access.prepost.PostAuthorize
import org.springframework.security.access.prepost.PostFilter
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.access.prepost.PreFilter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {
    @GetMapping("/")
    fun index(): String {
        return "Hello, Kotlin for Springboot!!"
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello/admin")
    fun roleAdminHello(): String {
        return "Hello, I have admin role"
    }

    @PostAuthorize("hasRole('USER')")
    @GetMapping("/hello/user")
    fun roleUserHello(): String {
        return "Hello, I have user role"
    }

    @PreFilter(filterTarget="user", value="hasRole('ADMIN') and filterObject.age > 50")
    @PostMapping("/user/prefilter")
    fun preFilterUser(@RequestBody user: List<User>): List<User> {
        println("pre filter user")
        return user
    }

    @PostFilter(value="hasRole('TEST') and filterObject.age > 50")
    @PostMapping("/user/postfilter")
    fun postFilterUser(@RequestBody user: List<User>): List<User> {
        println("post filter user")
        return user
    }


}