package com.prac.extprac

open class View {
    open fun printMe() {
        println("View - member function.")
    }
}

class Button : View() {
    override fun printMe() {
        super.printMe()
        println("Button - member function.")
    }
}

fun main() {
    val b: Button = Button()
    b.printMe()

    val view = View()
    view.printMe()
}

// would be over shadowed by the member function with the same function name
fun View.printMe() {
    println("I am a View")
}

// would be over shadowed by the member function with the same function name
fun Button.printMe() {
    println("I am a Button")
}
