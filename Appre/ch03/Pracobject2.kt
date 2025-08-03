package com.prac.pracobject2

object Threshold {
    fun isAboveThreshold(value: Int): Boolean = if (value > 10) true else false
}

class Student private constructor(private val first_name: String, private val last_name: String) {
    companion object {
        fun loadStudent(studentMap: Map<String, String>): Student =
                Student(studentMap["first_name"] ?: "First", studentMap.get("last_name") ?: "Last")
    }

    override fun toString() = "Student(first_name: ${first_name}, last_name: ${last_name})"
}

interface ThresholdChecker {
    val lower: Int
    val upper: Int
    /** Returns true if value is higher than the upper threshold and false otherwise */
    fun isLit(value: Int): Boolean
    /** Returns true if value is less than the lower threshold and false otherwise */
    fun tooQuiet(value: Int): Boolean
}

fun main() {
    println("Above threshold: ${Threshold.isAboveThreshold(12)}")
    //
    val neils = Student.loadStudent(mapOf("first_name" to "Neils", "last_name" to "Bohr"))
    println(neils)
    println(Student.loadStudent(mapOf("first_name" to "Neils", "last" to "Bohr")))
    //
    val tc =
            object : ThresholdChecker {
                override val upper = 10
                override val lower = 7
                override fun isLit(value: Int): Boolean = value > upper
                override fun tooQuiet(value: Int): Boolean = value < lower
            }
    //
    println(tc.isLit(17))
    println(tc.tooQuiet(10))
}
