package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogTagRelation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BlogTagRelationService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun deleteByPrimaryKey(relationId: Long): Int {
        return 0
    }

    fun insert(record: BlogTagRelation): Int {
        return 0
    }

    fun insertSelective(record: BlogTagRelation): Int {
        return 0
    }

    fun selectByPrimaryKey(relationId: Long): BlogTagRelation {
        return BlogTagRelation()
    }

    fun selectByBlogIdAndTagId(blogId: Long, tagId: Int): BlogTagRelation {
        return BlogTagRelation()
    }

    fun selectDistinctTagIds(tagIds: Array<Int>): List<Long> {
        return listOf()
    }

    fun updateByPrimaryKeySelective(record: BlogTagRelation): Int {
        return 0
    }

    fun updateByPrimaryKey(record: BlogTagRelation): Int {
        return 0
    }

    fun batchInsert(blogTagRelationList: List<BlogTagRelation>): Int {
        return 0
    }

    fun deleteByBlogId(blogId: Long): Int {
        return 0
    }
}