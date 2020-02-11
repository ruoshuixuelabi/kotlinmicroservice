package io.kang.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NacosController {
    @Autowired
    lateinit var nacosConfig: NacosConfig

    @GetMapping("config")
    fun getNacosConfig(): String {
        return "${nacosConfig.env}-${nacosConfig.user}"
    }
}