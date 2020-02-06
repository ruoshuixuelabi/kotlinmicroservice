package io.kang.provider

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProviderController {

    @GetMapping("/provide")
    fun provide(): String {
        return "Hello From Provider"
    }
}