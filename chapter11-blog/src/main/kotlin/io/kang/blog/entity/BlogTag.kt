package io.kang.blog.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

class BlogTag {
    var tagId: Int? = null

    var tagName: String? = null
        set(tagName) {
            field = tagName?.trim { it <= ' ' }
        }

    var isDeleted: Byte? = null

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var createTime: Date? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, tagId=$tagId, tagName=$tagName, isDeleted=$isDeleted, createTime=$createTime]"
    }
}