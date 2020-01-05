package io.kang.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity//启用安全
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启注解
class KotlinSpringbootApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootApplication>(*args);
}
