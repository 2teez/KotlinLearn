package com.prac.pracobject3

import kotlin.math.PI

class Circle(private var radius: Double = 0.0) {
    val area: Double by lazy { PI * radius * radius }

    val circumference: Double
        get() = 2.0 * PI * radius
    fun getRadius() = radius
}

// creating a the receiver
object CircleExt {
    val Circle.diameter: Double
        get() = 2.0 * getRadius()
}

// with Extension property at top-level
val Circle.diameter: Double
    get() = 2.0 * getRadius()

fun Int.isEven() = 0 == this % 2

fun Int.isOdd() = !this.isEven()

fun main() {
    val c = Circle(3.25)
    println(c.area)
    with(CircleExt) { println(c.diameter) } // Access via the receiver
    println(c.diameter)
    //
    for (num in 0..10) {
        println("$num is Even: ${num.isEven()}")
    }
}
