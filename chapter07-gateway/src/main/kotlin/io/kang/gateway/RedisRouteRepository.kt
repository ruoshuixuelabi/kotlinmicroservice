package io.kang.gateway

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.gateway.route.RouteDefinition
import org.springframework.cloud.gateway.route.RouteDefinitionRepository
import org.springframework.cloud.gateway.support.NotFoundException
import org.springframework.data.redis.core.RedisTemplate
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.LinkedHashMap
import java.util.LinkedList

class RedisRouteRepository: RouteDefinitionRepository {
    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, RouteDefinition>

    val routeKey = "route"

    override fun save(route: Mono<RouteDefinition>): Mono<Void> {
        return route
                .flatMap { routeDefinition ->
                    redisTemplate.opsForHash<String, RouteDefinition>().put(routeKey, routeDefinition.id,
                            routeDefinition)
                    Mono.empty()
                }
    }

    override fun getRouteDefinitions(): Flux<RouteDefinition> {
        var routes: Map<String, RouteDefinition>

        if (redisTemplate.hasKey(routeKey)) {
            // redis中拉取路由
            val routeDefinitions = LinkedList<RouteDefinition>()
            redisTemplate
                    .opsForHash<String, RouteDefinition>().values(routeKey)
                    .stream()
                    .forEach { routeDefinition -> routeDefinitions.add(routeDefinition as RouteDefinition) }
            return Flux.fromIterable(routeDefinitions)
        } else {
            routes = LinkedHashMap<String, RouteDefinition>()
            redisTemplate.opsForHash<String, RouteDefinition>().putAll(routeKey, routes)
            return Flux.fromIterable(routes.values)
        }

    }

    override fun delete(routeId: Mono<String>): Mono<Void> {
        return routeId
                .flatMap { routeId ->
                    if (redisTemplate.opsForHash<String, String>().hasKey(routeKey, routeId)) {
                        redisTemplate.opsForHash<String, String>().delete(routeKey, routeId)
                        Mono.empty()
                    } else
                        Mono.defer {
                            Mono.error(NotFoundException("RouteDefinition not found: $routeId"))
                        }
                }
    }

}