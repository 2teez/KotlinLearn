package com.prac.pracfunctionex

data class Complex(val real: Double, val imag: Double) {
    operator fun plus(other: Complex) = Complex(real + other.real, imag + other.imag)

    override fun toString() = "Complex(real=$real, imag=${imag}i)"
}

fun main() {
    println("Hello, World!")
    var cmplx = Complex(2.0, 8.3)
    val cmplx2 = Complex(0.0, 1.15)

    cmplx += cmplx2
    println(cmplx)
}
