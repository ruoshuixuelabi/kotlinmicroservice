package io.kang.zuul

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("zuul")
@RefreshScope
class ZuulProperty {
    fun zuulProperties(): ZuulProperties {
        return ZuulProperties()
    }
}