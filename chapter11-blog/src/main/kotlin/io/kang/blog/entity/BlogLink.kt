package io.kang.blog.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_link")
class BlogLink {
    @Id
    var linkId: Int? = null

    var linkType: Byte? = null

    var linkName: String? = null
        set(linkName) {
            field = linkName?.trim { it <= ' ' }
        }

    var linkUrl: String? = null
        set(linkUrl) {
            field = linkUrl?.trim { it <= ' ' }
        }

    var linkDescription: String? = null
        set(linkDescription) {
            field = linkDescription?.trim { it <= ' ' }
        }

    var linkRank: Int? = null

    var isDeleted: Byte? = null

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var createTime: Date? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, linkId=$linkId, linkType=$linkType, linkName=$linkName" +
                ", linkUrl=$linkUrl, linkDescription=$linkDescription, linkRank=$linkRank, isDeleted=$isDeleted, createTime=$createTime]"
    }
}