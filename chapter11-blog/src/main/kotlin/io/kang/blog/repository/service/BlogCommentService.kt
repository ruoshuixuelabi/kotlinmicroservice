package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogComment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BlogCommentService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun deleteByPrimaryKey(commentId: Long): Int {
        return 0
    }

    fun insert(record: BlogComment): Int {
        return 0
    }

    fun insertSelective(record: BlogComment): Int {
        return 0
    }

    fun selectByPrimaryKey(commentId: Long?): BlogComment {
        return BlogComment()
    }

    fun updateByPrimaryKeySelective(record: BlogComment): Int {
        return 0
    }

    fun updateByPrimaryKey(record: BlogComment): Int {
        return 0
    }

    fun findBlogCommentList(map: Map<*, *>): List<BlogComment> {
        return listOf()
    }

    fun getTotalBlogComments(map: Map<*, *>): Int {
        return 0
    }

    fun checkDone(ids: Array<Int>): Int {
        return 0
    }

    fun deleteBatch(ids: Array<Int>): Int {
        return 0
    }
}