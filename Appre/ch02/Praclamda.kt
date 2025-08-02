import java.util.HashMap

fun main() {
    val names = listOf("java", "rust", "clojure", "erlang", "exlir", "python")
    names.fold("") { a, b -> a + b }
    println(names)
    println(names.filter { it.length > 4 }.reduce { a, b -> a + b })

    val namesAndAges = mapOf("java" to 30, "cpp" to 35, "c" to 45, "rusta" to 10, "prolong" to 12)
    println(namesAndAges.filter { it.value < 18 })
    println(namesAndAges.filter { it.value >= 18 }.map { it.key })
    //
    repeatTask(10) { println("Kotlin Apprentice is a good book!") }
    repeatTask { println("Kotlin Apprentice is a good book Again!") }
    //
    println(mathSum(10) { it * it })
    println(mathSum(10, ::fibo))
    //
    val appRatings =
            mapOf(
                    "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
                    "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
                    "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
            )
    val averageRatings = HashMap<String, Int>()
    appRatings.forEach { averageRatings.put(it.key, it.value.sum() / it.value.size) }

    println(averageRatings.filter { it.value >= 3 }.map { it.key })
}

fun repeatTask(times: Int = 1, task: () -> Unit) {
    repeat(times) { task() }
}

fun mathSum(length: Int, series: (Int) -> Int): Int {
    var sum = 0
    for (item in 0..length) {
        sum += series(item)
    }
    return sum
}

fun fibo(num: Int): Int =
        when (num) {
            0 -> 0
            in 1..2 -> 1
            else -> fibo(num - 2) + fibo(num - 1)
        }
