package io.kang.prometheus

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {
    @GetMapping("/prometheus")
    fun testPrometheus(): String {
        return "hello prometheus"
    }
}