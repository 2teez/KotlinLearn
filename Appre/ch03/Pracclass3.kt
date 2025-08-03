package com.prac.pracclass3

open class A {
    init {
        println("I'm A")
    }
}

open class B : A() {
    init {
        println("I'm B")
    }
}

class C : B() {
    init {
        println("I'm C")
    }
}

/// sealed classes
sealed class Resource {
    class Success(val data: String) : Resource()
    class Loading : Resource()
    class Error(val error: String) : Resource()
}

fun main() {
    val c = C()
    println((c as? A))
    val a = A()
    println(a as? C) // error for (a as C)
}
