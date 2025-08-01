import java.util.Random
import kotlin.math.*

fun main() {
    var counter = 0
    do {
        var roll = Random().nextInt(6)
        counter += 1
        println("Roll is $roll and counter is $counter")
    } while (roll != 0)

    // find power of two
    //
    var numberCounter = 0
    var value = 0
    while (true) {
        if (powerOfTwo(value.toDouble())) {
            println("$value has a power of two ${log2(value.toDouble())}")
            numberCounter++
        }
        if (numberCounter == 10) {
            break
        }
        value++
    }
    // fibonacci
    for (num in 0..24) {
        println("$value -> ${fibonacci(num)}")
    }
    println("factorial 5 is ${factorial(5)}")
}

fun powerOfTwo(num: Double) = 0 == num.toInt() % 2

fun fibonacci(num: Int): Int =
        when (num) {
            0 -> 0
            in 1..2 -> 1
            else -> fibonacci(num - 2) + fibonacci(num - 1)
        }

fun factorial(num: Int): Int =
        when (num) {
            in 0..1 -> 1
            else -> num * factorial(num - 1)
        }
