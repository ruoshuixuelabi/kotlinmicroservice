package io.kang.blog.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_blog_tag_relation")
class BlogTagRelation {
    @Id
    var relationId: Long? = null

    var blogId: Long? = null

    var tagId: Int? = null

    var createTime: Date? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, relationId=$relationId, " +
                "blogId=$blogId, tagId=$tagId, createTime=$createTime]"
    }
}