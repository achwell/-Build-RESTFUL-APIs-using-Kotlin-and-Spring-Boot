package com.kotlinplayground.collections

fun main() {
    val names = listOf("Alex", "Ben", "Chloe")
    println(names)

    val namesMutable = mutableListOf("Alex", "Ben", "Chloe")
    println(namesMutable)
    namesMutable.add("Dave")
    println(namesMutable)

    val set = setOf("Alex", "Ben", "Chloe")
    println(set)

    val setMutable = mutableSetOf("Alex", "Ben", "Chloe")
    println(setMutable)
    setMutable.add("Dave")
    println(setMutable)
    setMutable.add("Alex")
    println(setMutable)

    val map = mapOf("Dilip" to 34, "Scooby" to 4)
    println(map)
    val mapMutable = mutableMapOf("Dilip" to 34, "Scooby" to 4)
    println(mapMutable)
    mapMutable["Jesper"] = 7
    println(mapMutable)
}