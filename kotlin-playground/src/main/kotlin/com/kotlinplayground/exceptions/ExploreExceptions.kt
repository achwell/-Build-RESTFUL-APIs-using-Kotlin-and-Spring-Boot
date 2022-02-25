package com.kotlinplayground.exceptions

fun main() {
    println("Name length is ${nameLength("Dilip")}")
    println("Name length is ${nameLength(null)}")
    returnNothing()
}

fun nameLength(name: String?): Int? {
    return try {
        name!!.length
    } catch (e: Exception) {
        println("Exception: ${e}")
        null
    }
}

fun returnNothing():Nothing {
    throw RuntimeException("Exception")
}