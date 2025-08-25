package com.prac.pracinfixfun

class Person(val name: String, val lastName: String) {
    val fullName: String
        get() = "$name, $lastName"
}

infix fun Person.remaned(name: String) = this.fullName.replace(this.name, name)

fun main() {
    "Hello, World!".print()
    (Person("java", "jvm") remaned "JAVA").print()
}

fun Any?.print() = println(this)
