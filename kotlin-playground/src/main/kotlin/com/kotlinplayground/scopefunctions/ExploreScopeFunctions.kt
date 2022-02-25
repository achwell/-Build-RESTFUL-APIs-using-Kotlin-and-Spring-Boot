package com.kotlinplayground.scopefunctions

import com.kotlinplayground.classes.Course
import com.kotlinplayground.classes.CourseCategory

fun main() {
    exploreApply()
    exploreAlso()
    exploreLet()
    exploreWith()
    exploreRun()
}

fun exploreApply() {
    val course = Course(1, "Design Thinking in Kotlin", "Dilip")
        .apply { courseCategory = CourseCategory.DESIGN }
    println("course: ${course}")
}

fun exploreAlso() {
    val course = Course(1, "Design Thinking in Kotlin", "Dilip")
        .apply { courseCategory = CourseCategory.DESIGN }
        .also { println("course: ${it}") }
}

fun exploreLet() {
    val numbers = mutableListOf<Int>(1, 2, 3, 4, 5)
    val result = numbers
        .map { it * 2 }
        .filter { it > 5 }
        .let {
            println(it)
            it.sum()
        }
    println(result)

    var name : String? = null
    name = "Dilip"
    val result1 = name?.let {
        println(it)
        it.uppercase()
    }
    println(result1)

}

fun exploreWith() {
    val numbers = mutableListOf<Int>(1, 2, 3, 4, 5)
    val result = with(numbers) {
        println("Size is ${size}")
        plus(6)
        sum()
    }
    println("With result is : $result")
}

fun exploreRun() {
    var numbers : MutableList<Int>? = null
    val result = numbers.run {
        println("Inside run")
        numbers = mutableListOf(1,2,3)
        numbers?.sum()
    }
    println("result in Run : $result")

    val length = run {
        val name = "Dilip"
        println(name)
        name.length
    }
    println("length : $length")
}