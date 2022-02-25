package com.kotlinplayground.collections

fun calculate(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}

fun main() {
    val addLambda = { x: Int -> x + x }
    val multiplyLambda = { x: Int, y: Int ->
        println("x is ${x}")
        println("y is ${y}")
        x * y
    }

    val addResult = addLambda(3)
    println(addResult)

    val multiplyResult = multiplyLambda(2, 3)
    println(multiplyResult)

    val calculate = calculate(2, 3, multiplyLambda)
    println(calculate)

    val calculate2 = calculate(2, 3) { a, b -> a * b }
    println(calculate2)
}