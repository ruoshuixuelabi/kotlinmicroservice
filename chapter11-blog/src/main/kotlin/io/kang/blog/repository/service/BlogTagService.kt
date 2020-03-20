package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogTag
import io.kang.blog.entity.BlogTagCount
import io.kang.blog.util.PageQueryUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BlogTagService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun deleteByPrimaryKey(tagId: Int): Int {
        return 0
    }

    fun insert(record: BlogTag): Int {
        return 0
    }


    fun insertSelective(record: BlogTag): Int {
        return 0
    }


    fun selectByPrimaryKey(tagId: Int): BlogTag {
        return BlogTag()
    }


    fun selectByTagName(tagName: String): BlogTag {
        return BlogTag()
    }


    fun updateByPrimaryKeySelective(record: BlogTag): Int {
        return 0
    }


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


    fun deleteBatch(ids: Array<Int>): Int {
        return 0
    }


    fun batchInsertBlogTag(tagList: List<BlogTag>): Int {
        return 0
    }

}