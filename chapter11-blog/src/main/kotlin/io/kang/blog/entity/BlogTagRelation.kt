package io.kang.blog.entity

import java.util.*

class BlogTagRelation {
    var relationId: Long? = null

    var blogId: Long? = null

    var tagId: Int? = null

    var createTime: Date? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, relationId=$relationId, " +
                "blogId=$blogId, tagId=$tagId, createTime=$createTime]"
    }
}