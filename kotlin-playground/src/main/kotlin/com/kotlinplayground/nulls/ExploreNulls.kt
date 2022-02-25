package com.kotlinplayground.nulls

data class Movie(val id: Int?, val name: String)


fun main() {
    var nameNullable : String? = null
    println("Value is ${nameNullable}")
    nameNullable?.run { printName(this) }
    println("Value is ${printName1(nameNullable)}")

    println("Length is ${nameNullable?.length?.toLong() ?: 0}")

    nameNullable = "Dilip"
    println("Value is ${nameNullable}")
    println("Length is ${nameNullable.length}")

    var nonNameNullable : String = "Dilip"
    println("Value is ${nonNameNullable}")

    val movie = Movie(null, "Avengers")
    println("Movie ${movie}")
    val savedMovie = saveMovie(movie)
    println(savedMovie.id!!)
    println("Saved Movie ${savedMovie}")


}

fun saveMovie(movie: Movie): Movie {
    return movie.copy(id=1)
}

fun printName(name: String) {
    println("Name is ${name}")
}
fun printName1(name: String?) {
    println("Name is ${name}")
}