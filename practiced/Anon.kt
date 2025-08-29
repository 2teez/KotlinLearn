package com.prac.anon

fun main() {
    val sayHello = fun() = println("Hello, World!") // anon
    sayHello()

    val anSayHello = { println("Howdy World!") } // lambda expression
    anSayHello.invoke()
    //
    var fc = kounter()
    var sc = kounter()
    println(fc())
    println(fc())
    println(fc())
    pp("second counter -> ") { println(sc()) }
    pp("second counter -> ") { println(sc()) }
    pp("first counter -> ") { println(fc()) }
}

fun kounter(count: Int = 0): () -> Int {
    var lCount = count
    return { lCount++ }
}

fun pp(msg: String = "", fn: () -> Unit) {
    print(msg)
    fn()
}
