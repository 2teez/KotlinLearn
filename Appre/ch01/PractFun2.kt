fun main() {
    println(divideIfWhole(4, 3) ?: 0)
    println(divideIfWhole(81, 9) ?: 0)
    //
    println(displayResult(divideIfWhole(10, 2)))
    println(displayResult(divideIfWhole(10, 3)))
}

fun displayResult(result: Int?): String =
        when {
            result == null -> "Not divisible: ["
            else -> "Yep, it divides $result times"
        }

fun divideIfWhole(value: Int, divisor: Int): Int? =
        if (0 == value % divisor) value / divisor else null
