package com.kotlinplayground.functions

import java.time.LocalDate
import java.time.LocalDate.now

fun main() {
    val unit = printName("Dilip")
    println("Unit is $unit")
    val result = addition(2,3)
    println("Result is $result")

    val result2 = addition_approach1(2,3)
    println("Result is $result2")
    printMultipleThings("A", "B", "C")
    printPersonDetails("Dilip", "abc@gmail.com" , LocalDate.parse("2000-01-01") )
    printPersonDetails("Dilip")
    printPersonDetails("Dilip", dob = LocalDate.parse("2000-01-01") )
    printPersonDetails(dob = LocalDate.parse("2000-01-01") , name = "Dilip", email = "abc@gmail.com")

    returnNothing()
}

fun returnNothing() : Nothing {
    throw RuntimeException("Exception")
}

fun printPersonDetails(name : String, email : String = "", dob : LocalDate = now()){
    println("Name is $name and the email is $email and the dob is $dob")
}

fun printMultipleThings(vararg  alphabets: String) {
    println("strings : $alphabets")
    for(alphabet in alphabets ){
        println(alphabet)
    }

    val alphabetList = listOf(*alphabets)
    println("alphabetList : $alphabetList")
}

fun addition_approach1(i: Int, i1: Int) = i + i1

fun addition(i: Int, i1: Int): Int {
    return i + i1
}

fun printName(name: String): Unit {
    println("Name is $name")
}
