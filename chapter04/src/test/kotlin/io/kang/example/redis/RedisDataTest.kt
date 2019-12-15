package io.kang.example.redis

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class RedisDataTest {
    @Autowired
    lateinit var redisData: RedisData

    @Test
    fun saveString() {
        redisData.saveString("hello", "helloWorld")
    }

    @Test
    fun saveStringWithExpire() {
        runBlocking {
            redisData.saveStringWithExpire("hello1", "helloWorld1", 2L)
            kotlinx.coroutines.delay(2 * 1000L)
        }
        println("get key")
        val value = redisData.getString("hello1")
        Assert.assertNull(value)
    }

    @Test
    fun getString() {
        val key = "hello"
        val value = redisData.getString(key)
        Assert.assertEquals(value, "helloWorld")
    }

    @Test
    fun saveList() {
        val values = arrayListOf("hi1", "hi2", "hi3")
        redisData.saveList("listKey", values)
    }

    @Test
    fun saveListWithExpire() {
        runBlocking {
            val values = arrayListOf("hi1", "hi2", "hi3")
            redisData.saveListWithExpire("listKey1", values, 2L)
            kotlinx.coroutines.delay(2 * 1000L)
        }

        val values = redisData.getListValue("listKey1")
        Assert.assertEquals(values?.size, 0)
    }

    @Test
    fun getListValue() {
        val values = redisData.getListValue("listKey")
        Assert.assertEquals(3, values?.size)
    }

    @Test
    fun saveSet() {
        val values = arrayOf("hello", "hello", "world", "wide")
        val values1 = arrayOf("hello", "hello", "world", "women")

        redisData.saveSet("setKey1", values)
        redisData.saveSet("setKey2", values1)
    }

    @Test
    fun saveSetWithExpire() {
        runBlocking {
            val values = arrayOf("hello", "hello", "world")
            redisData.saveSetWithExpire("setKey3", values, 2L)
            kotlinx.coroutines.delay(2 * 1000L)
        }

        val values = redisData.getSetValues("setKey3");
        Assert.assertEquals(values?.size, 0)
    }

    @Test
    fun getSetDiff() {
        val diffSet = redisData.getSetDiff("setKey1", "setKey2")
        Assert.assertEquals(diffSet?.size, 1)
    }

    @Test
    fun saveZset() {
        val values = arrayOf(Pair("xiaoming",98.0), Pair("xiaoli", 90.0), Pair("wangming", 100.0))
        redisData.saveZset("zsetKey1", values)
    }

    @Test
    fun testSaveZset() {
        runBlocking {
            val values = arrayOf(Pair("xiaoming",98.0), Pair("xiaoli", 90.0), Pair("wangming", 100.0))
            redisData.saveZsetWithExpire("zsetKey2", values, 2L)
            kotlinx.coroutines.delay(2_000)
        }

        val values = redisData.getZsetRangeByScore("zsetKey2", 95.0, 99.0);
        Assert.assertEquals(values?.size, 0)
    }

    @Test
    fun getZsetRangeByScore() {
        val values = redisData.getZsetRangeByScore("zsetKey1", 95.0, 100.0)
        Assert.assertEquals(2, values?.size)
    }

    @Test
    fun saveHash() {
        val aMap = mapOf(Pair("key1","value1"), Pair("key2", "value2"))
        redisData.saveHash("hashKey1", aMap)
    }

    @Test
    fun saveHashExpire() {
        runBlocking {
            val aMap = mapOf(Pair("key1","value1"), Pair("key2", "value2"))
            redisData.saveHashWithExpire("hashKey2", aMap, 2L)
            kotlinx.coroutines.delay(2_000)
        }

        val values = redisData.getHashValues("hashKey2")
        Assert.assertEquals(0, values?.size)
    }

    @Test
    fun getHashValues() {
        val values = redisData.getHashValues("hashKey1")
        Assert.assertEquals(2, values?.size)
    }
}