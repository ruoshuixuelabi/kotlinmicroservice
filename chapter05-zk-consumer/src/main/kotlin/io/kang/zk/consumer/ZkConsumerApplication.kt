package io.kang.zk.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate




@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
class ZkConsumerApplication {
    @Bean
    @LoadBalanced
    fun restTemplate():
    //如果使用restTemplate远程调用，依赖于
            RestTemplate {
        return RestTemplate()
    }

}

fun main(args: Array<String>) {
    runApplication<ZkConsumerApplication>(*args)
}