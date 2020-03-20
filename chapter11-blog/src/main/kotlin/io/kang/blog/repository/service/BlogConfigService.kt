package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BlogConfigService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun selectAll(): List<BlogConfig> {
        return listOf()
    }

    fun selectByPrimaryKey(configName: String): BlogConfig {
        return BlogConfig()
    }

    fun updateByPrimaryKeySelective(record: BlogConfig): Int {
        return 0
    }
}