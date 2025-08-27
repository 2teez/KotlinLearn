package com.prac.practexception

// import java.util.Exception

class MathException(msg: String) : Exception(msg)

const val ZERO = 0

fun main() {

    print("Enter a number: ")
    val aNumber = readLine()?.toInt() ?: 0
    if (aNumber / ZERO != ZERO) {
        throw MathException("Can't Divide by $ZERO")
    }
    try {
        println(1 / 0)
    } catch (me: MathException) {
        printExceptions(me)
    } catch (ae: ArithmeticException) {
        println(ae)
    }
}

fun printExceptions(exception: Throwable) {
    println(exception.message)
}
