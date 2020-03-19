package io.kang.blog.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_admin_user")
class AdminUser {
    @Id
    var adminUserId: Int? = null

    var loginUserName: String? = null
        set(loginUserName) {
            field = loginUserName?.trim { it <= ' ' }
        }

    var loginPassword: String? = null
        set(loginPassword) {
            field = loginPassword?.trim { it <= ' ' }
        }

    var nickName: String? = null
        set(nickName) {
            field = nickName?.trim { it <= ' ' }
        }

    var locked: Byte? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, adminUserId=$adminUserId, loginUserName=$loginUserName" +
                ", loginPassword=$loginPassword, nickName=$nickName, locked=$locked]"
    }
}