package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.courseList
import java.util.function.BiPredicate

fun main() {
    val namesListUsingSequence = listOf("alex", "ben", "chloe")
        .asSequence()
        .filter { it.length >= 4 }
        .map { it.uppercase() }
        .toList()
    println("namesListUsingSequence : $namesListUsingSequence")

    val devPredicate: (Course) -> Boolean = { it.category == CourseCategory.DEVELOPEMENT }
    exploreFilterUsingSequense(courseList(), devPredicate)

    val range = 1..1000_000_000
    range
        .asSequence()
        .map { it.toDouble() }
        .take(40)
        .forEach {
            println("Value is : $it")
        }
}

private fun exploreFilterUsingSequense(courseList: List<Course>, predicate: (Course) -> Boolean) {
    courseList
        .asSequence()
        .filter(predicate)
        .forEach { println("Course: $it") }
}
