package com.prac.pracarray

fun main() {
    val arr = intArrayOf(8, 3, 7, 1, 0, 4, 0).toTypedArray()
    arr.print()
    arr.inPlaceReversal()
    arr.print()
    arr.isSorted().print()
    arr.inPlaceSorted()
    arr.print()
    arr.isSorted().print()
    arr.sum().print()
    arr.count(0).print()
}

fun Any?.print() = println(this)

fun <T> Array<T>.print() {
    println(this.joinToString(",", prefix = "[", postfix = "]"))
}

fun <T : Comparable<T>> Array<T>.isSorted(): Boolean {
    if (this.isEmpty()) return true
    var count = 0
    while (count < this.size - 1) {
        if (this[count] > this[count + 1]) return false
        count++
    }
    return true
}

fun <T> Array<T>.inPlaceReversal() {
    var counterCount = this.size - 1
    var count = 0
    while (counterCount != count) {
        val temp = this[count]
        this[count] = this[counterCount]
        this[counterCount] = temp
        counterCount--
        count++
    }
}

fun <T> Array<T>.count(value: T) = this.filter { it == value }.count()

fun <T : Comparable<T>> Array<T>.inPlaceSorted() {
    for (idx1 in 0..this.size - 1) {
        for (idx2 in 0..this.size - 1) {
            if (this[idx1] < this[idx2]) {
                val tmp = this[idx1]
                this[idx1] = this[idx2]
                this[idx2] = tmp
            }
        }
    }
}
