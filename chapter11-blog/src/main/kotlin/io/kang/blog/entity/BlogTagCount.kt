package io.kang.blog.entity

class BlogTagCount {
    var tagId: Int? = null

    var tagName: String? = null

    var tagCount: Int? = null

    override fun toString(): String {
        return "tagId:$tagId, tagName:$tagName, tagCount:$tagCount"
    }
}