fun Any?.print() {
    print(this)
}

fun printNumberSign(num: Int) {
    if (num < 0) {
                "negative"
            } else {
                if (num > 0) {
                    "positivs"
                } else {
                    "zero"
                }
            }
            .print()
}

fun printNumberSignWhen(num: Int) =
        println(
                when {
                    num < 0 -> "negative"
                    num > 0 -> "positive"
                    else -> "zero"
                }
        )

fun main() {
    val superpower = false
    val result =
            if (superpower) {
                println("It is the Admin")
                1
            } else {
                0
            }
    println("My Result of superpower is ${result}")
    //
    printNumberSign(-2)
    print(",")
    printNumberSign(0)
    print(",")
    printNumberSign(2)
    printNumberSignWhen(-3)
}
