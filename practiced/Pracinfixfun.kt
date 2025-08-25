package com.prac.pracinfixfun

interface Humanable {
    val name: String
}

class Person(override val name: String, val lastName: String) : Humanable {
    var fullName: String
        get() = "$name, $lastName"
        set(value) {
            fullName += value
        }
    infix fun add(person: Person): Person {
        this.fullName += person.fullName
        return this
    }
}

infix fun Person.remaned(name: String) = this.fullName.replace(this.name, name)

fun main() {
    "Hello, World!".print()
    (Person("java", "jvm") remaned "JAVA").print()

    var name = "clojure"
    name += ", jvm"
    name.print()

    val names = mutableListOf("java", "rust", "zig-lang")
    names += "python"
    names += "perl"
    names.print()
}

fun Any?.print() = println(this)
