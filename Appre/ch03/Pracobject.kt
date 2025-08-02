package com.prac.pracobject

object Logger {
    fun log(msg: String) {
        println("[LOG] $msg")
    }
}

class User private constructor(val name: String) {
    companion object {
        fun create(name: String): User {
            return User(name)
        }
    }
}

class MathUtils {
    fun square(x: Int) = x * x
    companion object {
        fun sum(a: Int, b: Int) = a + b
    }
}

fun main() {
    Logger.log("Hello, World!")
    Logger.log("starting application...")
    Logger.log("Done.")
    //
    val user = User.create("Ada")
    println(user.name) // Ada
    //
    println(MathUtils().square(3))
    println(MathUtils.sum(2, 9))
}
