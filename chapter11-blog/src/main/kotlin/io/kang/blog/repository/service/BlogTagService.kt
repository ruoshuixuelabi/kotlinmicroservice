package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogTag
import io.kang.blog.entity.BlogTagCount
import io.kang.blog.util.PageQueryUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class BlogTagService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    @Transactional
    fun deleteByPrimaryKey(tagId: Int): Int {
        return 0
    }

    @Transactional
    fun insert(record: BlogTag): Int {
        return 0
    }

    @Transactional
    fun insertSelective(record: BlogTag): Int {
        return 0
    }


    fun selectByPrimaryKey(tagId: Int): BlogTag {
        return BlogTag()
    }


    fun selectByTagName(tagName: String): BlogTag {
        return BlogTag()
    }


    @Transactional
    fun updateByPrimaryKeySelective(record: BlogTag): Int {
        return 0
    }


    @Transactional
    fun updateByPrimaryKey(record: BlogTag): Int {
        return 0
    }


    fun findTagList(pageUtil: PageQueryUtil): List<BlogTag> {
        return listOf()
    }


    fun getTagCount(): List<BlogTagCount> {
        return listOf()
    }


    fun getTotalTags(pageUtil: PageQueryUtil): Int {
        return 0
    }

    @Transactional
    fun deleteBatch(ids: Array<Int>): Int {
        return 0
    }

    @Transactional
    fun batchInsertBlogTag(tagList: List<BlogTag>): Int {
        return 0
    }

}