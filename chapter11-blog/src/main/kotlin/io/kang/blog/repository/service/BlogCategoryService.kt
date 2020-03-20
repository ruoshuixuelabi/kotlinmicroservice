package io.kang.blog.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import io.kang.blog.entity.BlogCategory
import io.kang.blog.util.PageQueryUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BlogCategoryService {
    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun deleteByPrimaryKey(categoryId: Int): Int {
        return 0
    }

    fun insert(record: BlogCategory): Int {
        return 0
    }

    fun insertSelective(record: BlogCategory): Int {
        return 0
    }

    fun selectByPrimaryKey(categoryId: Int?): BlogCategory {
        return BlogCategory()
    }

    fun selectByCategoryName(categoryName: String): BlogCategory {
        return BlogCategory()
    }

    fun updateByPrimaryKeySelective(record: BlogCategory): Int {
        return 0
    }

    fun updateByPrimaryKey(record: BlogCategory): Int {
        return 0
    }

    fun findCategoryList(pageUtil: PageQueryUtil): List<BlogCategory> {
        return listOf()
    }

    fun selectByCategoryIds(categoryIds: List<Int>): List<BlogCategory> {
        return listOf()
    }

    fun getTotalCategories(pageUtil: PageQueryUtil): Int {
        return 0
    }

    fun deleteBatch(ids: Array<Int>): Int {
        return 0
    }
}