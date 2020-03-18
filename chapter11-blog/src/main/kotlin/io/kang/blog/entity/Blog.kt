package io.kang.blog.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

class Blog {
    var blogId: Long? = null

    var blogTitle: String? = null
        set(blogTitle) {
            field = blogTitle?.trim { it <= ' ' }
        }

    var blogSubUrl: String? = null
        set(blogSubUrl) {
            field = blogSubUrl?.trim { it <= ' ' }
        }

    var blogCoverImage: String? = null
        set(blogCoverImage) {
            field = blogCoverImage?.trim { it <= ' ' }
        }

    var blogCategoryId: Int? = null

    var blogCategoryName: String? = null
        set(blogCategoryName) {
            field = blogCategoryName?.trim { it <= ' ' }
        }

    var blogTags: String? = null
        set(blogTags) {
            field = blogTags?.trim { it <= ' ' }
        }

    var blogStatus: Byte? = null

    var blogViews: Long? = null

    var enableComment: Byte? = null

    var isDeleted: Byte? = null

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var createTime: Date? = null

    var updateTime: Date? = null

    var blogContent: String? = null
        set(blogContent) {
            field = blogContent?.trim { it <= ' ' }
        }

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, blogId=$blogId, blogTitle=$blogTitle, blogSubUrl=$blogSubUrl" +
                ", blogCoverImage=$blogCoverImage, blogCategoryId=$blogContent, blogCategoryName=$blogCategoryName, blogTags=$blogTags" +
                ", blogStatus=$blogStatus, blogViews=$blogViews, enableComment=$enableComment, isDeleted=$isDeleted" +
                ", createTime=$createTime, updateTime=$updateTime, blogContent=$blogContent]"
    }
}