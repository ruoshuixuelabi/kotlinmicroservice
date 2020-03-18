package io.kang.blog.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

class BlogComment {
    var commentId: Long? = null

    var blogId: Long? = null

    var commentator: String? = null
        set(commentator) {
            field = commentator?.trim { it <= ' ' }
        }

    var email: String? = null
        set(email) {
            field = email?.trim { it <= ' ' }
        }

    var websiteUrl: String? = null
        set(websiteUrl) {
            field = websiteUrl?.trim { it <= ' ' }
        }

    var commentBody: String? = null
        set(commentBody) {
            field = commentBody?.trim { it <= ' ' }
        }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var commentCreateTime: Date? = null

    var commentatorIp: String? = null
        set(commentatorIp) {
            field = commentatorIp?.trim { it <= ' ' }
        }

    var replyBody: String? = null
        set(replyBody) {
            field = replyBody?.trim { it <= ' ' }
        }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var replyCreateTime: Date? = null

    var commentStatus: Byte? = null

    var isDeleted: Byte? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, commentId=$commentId, blogId=$blogId, commentator=$commentator" +
                ", email=$email, websiteUrl=$websiteUrl, commentBody=$commentBody, commentCreateTime=$commentCreateTime" +
                ", commentatorIp=$commentatorIp, replyBody=$replyBody, replyCreateTime=$replyCreateTime, " +
                "commentStatus=$commentStatus, isDeleted=$isDeleted]"
    }
}