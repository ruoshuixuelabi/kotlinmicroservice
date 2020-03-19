package io.kang.blog.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_config")
class BlogConfig {
    @Id
    var configName: String? = null
        set(configName) {
            field = configName?.trim { it <= ' ' }
        }

    var configValue: String? = null
        set(configValue) {
            field = configValue?.trim { it <= ' ' }
        }

    var createTime: Date? = null

    var updateTime: Date? = null

    override fun toString(): String {
        return "${javaClass.simpleName} [Hash = ${hashCode()}, configName=$configName, " +
                "configValue=$configValue, createTime=$createTime, updateTime=$updateTime]"
    }
}