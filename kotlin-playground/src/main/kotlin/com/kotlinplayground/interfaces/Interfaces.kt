package com.kotlinplayground.interfaces

import com.kotlinplayground.functions.Course

interface CourseRepository {
    val isCoursePersisted: Boolean
        get() = false

    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("Course to save is $course")
        return course.id
    }
}

interface Repository {

    fun getAll(): Any
}

class SqlCourseRepository : CourseRepository, Repository {
    override var isCoursePersisted: Boolean = false
        get() {
            return true
        }

    override fun getById(id: Int): Course {
        return Course(id, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    }
    override fun save(course: Course): Int {
        println("course in SqlCourseRepository : $course")
        isCoursePersisted = true
        return course.id
    }

    override fun getAll(): Any {
        TODO("Not yet implemented")
    }
}

class NoSqlCourseRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(id, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    }

    override fun save(course: Course): Int {
        println("Course to save in NoSqlCourseRepository is $course")
        return course.id
    }
}

interface A {
    fun doSomething() {
        println("Do Something in A")
    }
}

interface B {
    fun doSomething() {
        println("Do Something in B")
    }
}

class AB : A, B {
    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("Do something in AB")
    }

}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(2)
    println("Course is $course")
    val courseId =
        sqlCourseRepository.save(Course(3, "Reactive Programming in Modern Java using Project Reactor", "Dilip"))
    println("Saved courseId is $courseId")
    println("Course persisted? ${sqlCourseRepository.isCoursePersisted}")

    val noSqlCourseRepository = NoSqlCourseRepository()
    val course1 = sqlCourseRepository.getById(1)
    println("Course is $course1")
    val courseId1 = noSqlCourseRepository.save(course1)
    println("Saved courseId is $courseId1")
    println("Course persisted? ${noSqlCourseRepository.isCoursePersisted}")

    val ab = AB()
    ab.doSomething()
}