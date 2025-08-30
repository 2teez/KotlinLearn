package com.prac.anon

fun main() {
    val sayHello = fun() = println("Hello, World!") // anon
    sayHello()

    val anSayHello = { println("Howdy World!") } // lambda expression
    anSayHello.invoke()
    //
    val fc = kounter()
    val sc = kounter()
    println(fc)
    println(fc)
    println(fc)
    pp("second counter -> ") { println(sc) }
    pp("second counter -> ") { println(sc) }
    pp("first counter -> ") { println(fc) }
    //
    val pl =
            fun(msg: String, fn: () -> Unit) {
                print(msg)
                fn()
            }

    pl("Anonymous Function: ") { println(sc) }

    val lambda: (String, () -> Unit) -> Unit = { msg, f ->
        print(msg)
        f()
    }
    lambda("Another counter -> ") { println(fc) }
}

fun kounter(count: Int = 0): () -> Int {
    var lCount = count
    return { lCount++ }
}

inline fun pp(msg: String = "", fn: () -> Unit) {
    print(msg)
    fn()
}
