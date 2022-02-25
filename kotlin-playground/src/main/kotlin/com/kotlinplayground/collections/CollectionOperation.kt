package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.KAFKA
import com.kotlinplayground.dataset.courseList

fun main() {
    val courseList = courseList()

    val devPredicate: (Course) -> Boolean = { it.category == CourseCategory.DEVELOPEMENT }
    val desPredicate: (Course) -> Boolean = { it.category == CourseCategory.DESIGN }

    exploreFilter(courseList, devPredicate)
    exploreFilter(courseList, desPredicate)

    exploreMap(courseList, desPredicate)


    val list = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
    val mapResult = list.map { outerList -> outerList.map { it.toDouble() } }
    println(mapResult)
    val flatMapResult = list.flatMap { outerList -> outerList.map { it.toDouble() } }
    println(flatMapResult)

    val kafkaCourses = exportFlatMap(courseList, KAFKA)
    println(kafkaCourses)

    exploreHashMap()

    collections_nullability()
}

fun collections_nullability() {
    var list: MutableList<String>? = null
    list = mutableListOf()
    list.add("Dilip")
    list.forEach { println("Value is ${it}") }

    var list1: MutableList<String?> = mutableListOf("Adam", null, "Alex")
    list1.forEach { println("Value is ${it?.length}") }
}

fun exploreHashMap() {
    val nameAgeMutableMap = mutableMapOf("Dilip" to 33, "Scooby" to 5)
    nameAgeMutableMap.forEach { (k, v) -> println("Key: $k and the value is ${v}") }
    val value = nameAgeMutableMap.getOrElse("abc") { 666 }
    println("The value is ${value}")
    val result = nameAgeMutableMap.containsKey("abc")
    println("The result is ${result}")

    val filteredMap = nameAgeMutableMap
        .filterKeys { it.length > 5 }
        .map { it.key.uppercase() }
    println("The filteredMap is ${filteredMap}")

    val maxAge = nameAgeMutableMap.maxByOrNull { it.value }
    println("The maxAge is ${maxAge}")
}

fun exportFlatMap(courseList: List<Course>, topic: String): List<String> {
    return courseList
        .flatMap { course ->
            val courseName = course.name
            course.topicsCovered
                .filter { it == topic }
                .map { courseName }
        }
}

fun exploreMap(courseList: List<Course>, predicate: (Course) -> Boolean) {
    courseList
        .filter(predicate)
        .map { "${it.name} - ${it.category}" }
        .forEach({ println(it) })
}

private fun exploreFilter(courseList: List<Course>, predicate: (Course) -> Boolean) {
    courseList
        .filter { predicate.invoke(it) }
        .forEach { println("Course : $it") }
}