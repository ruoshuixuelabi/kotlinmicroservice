package io.kang.gateway

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class RequestRateLimiterConfig {
    @Bean("ipAddressKeyResolver")
    fun ipAddressKeyResolver(): KeyResolver {
        return KeyResolver {
            exchange ->  Mono.just(exchange.request.remoteAddress?.hostName.orEmpty())
        }
    }

    @Bean("apiKeyResolver")
    fun apiKeyResolver(): KeyResolver {
        return KeyResolver {
            exchange ->  Mono.just(exchange.request.path.value())
        }
    }

    @Bean("userKeyResolver")
    fun userKeyResolver(): KeyResolver {
        return KeyResolver {
            exchange ->  Mono.just(exchange.request.queryParams.getFirst("userId").orEmpty())
        }
    }
}