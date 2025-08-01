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
}
