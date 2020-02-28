package io.kang.stream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.cloud.stream.messaging.Source

@SpringBootApplication
@EnableBinding(Source::class, Sink::class)
class StreamApplication

fun main(args: Array<String>) {
    runApplication<StreamApplication>(*args)
}