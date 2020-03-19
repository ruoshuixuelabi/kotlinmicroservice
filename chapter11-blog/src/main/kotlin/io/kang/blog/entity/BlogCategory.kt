package io.kang.blog.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_blog_category")
class BlogCategory {
    @Id
    var categoryId: Int? = null

    var categoryName: String? = null
        set(categoryName) {
            field = categoryName?.trim { it <= ' ' }
        }

    var categoryIcon: String? = null
        set(categoryIcon) {
            field = categoryIcon?.trim { it <= ' ' }
        }

    var categoryRank: Int? = null

    var isDeleted: Byte? = null

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var createTime: Date? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, categoryId=$categoryId, categoryName=$categoryName, categoryIcon=$categoryIcon" +
                ", categoryRank=$categoryRank, isDeleted=$isDeleted, createTime=$createTime]"
    }
}