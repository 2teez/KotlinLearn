package com.prac.anon

fun main() {
    val sayHello = fun() = println("Hello, World!") // anon
    sayHello()

    val anSayHello = { println("Howdy World!") } // lambda expression
    anSayHello.invoke()
}
