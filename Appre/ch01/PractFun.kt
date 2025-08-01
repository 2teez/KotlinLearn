import kotlin.math.sqrt

fun main() {
    println(printFullName("jvm"))
    println(printFullName("jvm", "clojure"))
    println(printFullName())
    println(calculateFullName(printFullName(firstname = "jvm", lastname = "groovy")))
    // prime number
    for (num in 2 until 10_000) {
        println("$num is a Prime Number: ${isPrime(num)}")
    }
}

fun printFullName(firstname: String = "", lastname: String = "") = firstname + " " + lastname

fun calculateFullNameLength(name: String = "") = name.length

fun calculateFullName(name: String = "") = Pair(name, calculateFullNameLength(name))

fun isPrime(num: Int): Boolean {
    var result = true
    if (num <= 1) {
        result = false
    } else {
        for (value in 2 until sqrt(num.toDouble()).toInt()) {
            if (0 == num % value) {
                result = false
            }
        }
    }
    return result
}
