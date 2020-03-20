package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogLink
import io.kang.blog.util.PageQueryUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BlogLinkService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun deleteByPrimaryKey(linkId: Int): Int {
        return 0
    }

    fun insert(record: BlogLink): Int {
        return 0
    }

    fun insertSelective(record: BlogLink): Int {
        return 0
    }

    fun selectByPrimaryKey(linkId: Int?): BlogLink {
        return BlogLink()
    }

    fun updateByPrimaryKeySelective(record: BlogLink): Int {
        return 0
    }

    fun updateByPrimaryKey(record: BlogLink): Int {
        return 0
    }

    fun findLinkList(pageUtil: PageQueryUtil): List<BlogLink> {
        return listOf()
    }

    fun getTotalLinks(pageUtil: PageQueryUtil): Int {
        return 0
    }

    fun deleteBatch(ids: Array<Int>): Int {
        return 0
    }
}