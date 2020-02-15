package io.kang.gateway

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class UriKeyResolver: KeyResolver {
    override fun resolve(exchange: ServerWebExchange): Mono<String> {
        return Mono.just(exchange.request.uri.path)
    }
}