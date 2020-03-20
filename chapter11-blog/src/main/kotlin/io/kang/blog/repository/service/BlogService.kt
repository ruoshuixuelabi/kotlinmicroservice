package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.Blog
import io.kang.blog.util.PageQueryUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BlogService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun deleteByPrimaryKey(blogId: Long): Int {
        return 0
    }

    fun insert(record: Blog): Int {
        return 0
    }


    fun insertSelective(record: Blog): Int {
        return 0
    }


    fun selectByPrimaryKey(blogId: Long): Blog {
        return Blog()
    }

    fun updateByPrimaryKeySelective(record: Blog): Int {
        return 0
    }


    fun updateByPrimaryKeyWithBLOBs(record: Blog): Int {
        return 0
    }


    fun updateByPrimaryKey(record: Blog): Int {
        return 0
    }


    fun findBlogList(pageUtil: PageQueryUtil): List<Blog> {
        return listOf()
    }


    fun findBlogListByType(type: Int, limit: Int): List<Blog> {
        return listOf()
    }


    fun getTotalBlogs(pageUtil: PageQueryUtil): Int {
        return 0
    }


    fun deleteBatch(ids: Array<Int>): Int {
        return 0
    }


    fun getBlogsPageByTagId(pageUtil: PageQueryUtil): List<Blog> {
        return listOf()
    }


    fun getTotalBlogsByTagId(pageUtil: PageQueryUtil): Int {
        return 0
    }


    fun selectBySubUrl(subUrl: String): Blog {
        return Blog()
    }


    fun updateBlogCategorys(categoryName: String, categoryId: Int?, ids: Array<Int>): Int {
        return 0
    }


}