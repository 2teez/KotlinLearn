package com.prac.practexception

// import java.util.Exception

class ArithmeticException(msg: String) : Exception(msg) {}

const val ZERO = 0

fun main() {

    print("Enter a number: ")
    val aNumber = readLine()?.toInt() ?: 0
    if (aNumber / ZERO != ZERO) {
        throw ArithmeticException("Can't Divide by $ZERO")
    }
    try {
        println(1 / 0)
    } catch (ae: ArithmeticException) {
        println(ae.stackTrace)
    }
}
