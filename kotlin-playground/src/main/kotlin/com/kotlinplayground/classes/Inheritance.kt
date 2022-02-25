package com.kotlinplayground.classes

open class User(val name: String, val age: Int = 0) {
    open val isLoggedIn : Boolean = true
    open fun login() {
        println("Inside user Login")
    }
    private fun secret(){

    }
    protected open fun logout(){
        println("Inside user logout")

    }
}

class Student(name: String, age: Int = 0): User(name, age) {
    override var isLoggedIn : Boolean = false
    companion object {
        const val noOfEnrolledCourses = 10
        fun country() = "Norge"
    }

    fun secret(){

    }

    override fun login() {
        super.login()
        println("Inside Student login")
        isLoggedIn = true
    }

    override fun logout() {
        super.logout()
        println("Inside Student logout")
        isLoggedIn = false
    }}

class Instructor(name: String): User(name)

fun main() {
    val student = Student("Alex", 1)
    println("name is : ${student.name}")
    println("age is : ${student.age}")
    println("isLoggedIn : ${student.isLoggedIn}")
    student.login()
    println("isLoggedIn : ${student.isLoggedIn}")

    val country = Student.country()
    println("country is : ${country}")
    println("noOfEnrolledCourses is : ${Student.noOfEnrolledCourses}")

    val instructor = Instructor("Dilip")
    println("name is : ${instructor.name}")
    println("age is : ${instructor.age}")
    println("isLoggedIn : ${instructor.isLoggedIn}")
}