package com.prac.pracdata

data class Person(var firstName: String, val lastName: String) {
    val fullName: String
        get() = "$firstName, $lastName"
}

fun main() {
    val p1 = Person("java", "jvm")
    val p2 = p1.copy()
    p2.firstName = "clojure"
    println("${p1.fullName}, ${p2.fullName}")
    println(p1 == p2)
}
