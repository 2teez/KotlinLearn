import java.util.Random

fun main() {
    val intArray = arrayOf(1, 5, 6, 7)
    intArray.forEach(::println)
    //
    val ages = listOf(4, 9, 23, 56, 70, 43, 43)
    println(ages.slice(2..5).joinToString())
    //
    var langs = mutableListOf("java")
    langs.add("clojure")
    langs.add("zig-lang")
    langs.add(2, "groovy")
    println("$langs, index of groovy is ${langs.indexOf("groovy")}")
    //
    println(removeOne(43, ages))
    println(remove(43, ages))
    println(reverse(ages.toTypedArray()).joinToString())
    println(randomized(ages.toTypedArray()).joinToString())
    println(minMax(ages.toTypedArray()))
    println("SHOW EMPTY: ${minMax(arrayOf<Int>())}")
}

fun removeOne(item: Int, list: List<Int>): List<Int> {
    var nlist = mutableListOf<Int>()
    val target = list.indexOf(item)
    for ((index, value) in list.withIndex()) {
        if (index != target) {
            nlist.add(value)
        }
    }
    return nlist
}

fun remove(item: Int, list: List<Int>): List<Int> {
    var nlist = mutableListOf<Int>()
    for (value in list) {
        if (value != item) {
            nlist.add(value)
        }
    }
    return nlist
}

fun reverse(array: Array<Int>): Array<Int> {
    var narray = mutableListOf<Int>()
    for (idx in array.size - 1 downTo 0) {
        narray.add(array[idx])
    }
    return narray.toTypedArray()
}

fun rand(from: Int, to: Int) = Random().nextInt(to - from) + from

fun randomized(list: Array<Int>): Array<Int> {
    val nlist = mutableListOf<Int>()
    repeat(list.size) { nlist.add(list[rand(0, list.size - 1)]) }
    return nlist.toTypedArray()
}

fun minMax(list: Array<Int>): Pair<Int, Int>? {
    if (list.isEmpty()) return null
    var minValue = Int.MAX_VALUE
    var maxValue = Int.MIN_VALUE
    for (value in list) {
        if (value < minValue) {
            minValue = value
        }
        if (value > maxValue) {
            maxValue = value
        }
    }
    // val result: Pair<Int, Int>? = Pair(minValue, maxValue)
    return minValue to maxValue // result
}
