package io.kang.chapter03.basicsyntax

import java.lang.StringBuilder
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val filterResults = mutableListOf<String>()  //destination object
    numbers.filterTo(filterResults) { it.length > 3 }
    println(filterResults) // contains results of both operations

    //map
    val numbers1 = setOf(1, 2, 3)
    println(numbers1.map { it * 3 })
    println(numbers1.mapIndexed { idx, value -> value * idx })

    println(numbers1.mapNotNull { if ( it == 2) null else it * 3 })
    println(numbers1.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })

    //zip

    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))
    println(colors.zip(animals) { color, animal -> "The ${animal.capitalize()} is $color"})

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())

    //associate
    val numbers2 = listOf("one", "two", "two", "four")
    println(numbers2.associateWith { it.length })

    println(numbers2.associateBy { it.first().toUpperCase() })
    println(numbers2.associateBy(keySelector = { it.first().toUpperCase() }, valueTransform = { it.length }))

    //flattern
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())

    val containers = listOf(
            (listOf("one", "two", "three")).associateWith { it.length },
            (listOf("four", "five", "six")).associateWith { it.length })
    println(containers.flatMap { it.keys })

    //zifuchuan

    val numbers3 = listOf("one", "two", "three", "four")

    println(numbers3)
    println(numbers3.joinToString())

    val listString = StringBuffer("The list of numbers: ")
    numbers3.joinTo(listString)
    println(listString)

    //filter
    val numbersMap1 = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap1.filter { (key, value) -> key.endsWith("1") && value > 10}
    println(filteredMap)

    val numbers4 = listOf("one", "two", "three", "four")

    val filteredIdx = numbers4.filterIndexed { index, s -> (index != 0) && (s.length < 5)  }
    val filteredNot = numbers4.filterNot { it.length <= 3 }

    println(filteredIdx)
    println(filteredNot)

    //plus minus

    val numbers5 = listOf("one", "two", "three", "four")

    val plusList = numbers5 + "five"
    val minusList = numbers5 - listOf("three", "four")
    println(plusList)
    println(minusList)

    //group

    val numbers6 = listOf("one", "two", "three", "four", "five")

    println(numbers6.groupBy { it.first().toUpperCase() })
    println(numbers6.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))
}