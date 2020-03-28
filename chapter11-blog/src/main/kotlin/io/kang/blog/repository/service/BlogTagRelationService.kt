package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogTagRelation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class BlogTagRelationService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    @Transactional
    fun deleteByPrimaryKey(relationId: Long): Int {
        return 0
    }

    @Transactional
    fun insert(record: BlogTagRelation): Int {
        return 0
    }

    @Transactional
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

    @Transactional
    fun updateByPrimaryKeySelective(record: BlogTagRelation): Int {
        return 0
    }

    @Transactional
    fun updateByPrimaryKey(record: BlogTagRelation): Int {
        return 0
    }

    @Transactional
    fun batchInsert(blogTagRelationList: List<BlogTagRelation>): Int {
        return 0
    }

    @Transactional
    fun deleteByBlogId(blogId: Long): Int {
        return 0
    }
}