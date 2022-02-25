package com.kotlinplayground.functions

data class Employee(val id: Int, val name: String)

fun main() {
    val employee = Employee(1, "Axel")
    println(employee)
    val employee1 = Employee(1, "Axel")
    println(employee1)
    println("Is Employee Equal ? : ${employee == employee1}")
    val employee2 = employee.copy(id = 2, name = "Wulff")
    println(employee2)
}