package com.kotlinplayground.cast

import com.kotlinplayground.functions.Course

fun main() {
    val course = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    checkType(course)
    checkType("Dilip")

    castNumber(1.0)
    castNumber(1)
}

fun castNumber(any: Any) {
    when(any) {
        any as? Double -> println("Value is double")
        any as? Int -> println("Value is integer")
    }
}

fun checkType(type: Any) {
    when (type) {
        is Course -> {
            println(type)
        }
        is String -> {
            println(type.lowercase())
        }
    }
}
