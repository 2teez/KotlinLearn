package com.prac.pracinterface

import kotlin.math.*

interface Area {
    val area: Double
}

sealed class Shape : Area {
    class Square(val side: Double) : Shape() {
        override val area: Double
            get() = this.side.pow(2.0)
    }
    class Triangle(val base: Double, val height: Double) : Shape() {
        override val area: Double
            get() = this.base * this.height / 2
    }
    class Circle(val radius: Double) : Shape() {
        override val area: Double
            get() = PI * this.radius.pow(2.0)
    }
}

fun main() {
    val shapes =
            mutableListOf<Shape>(Shape.Circle(3.15), Shape.Triangle(2.0, 4.21), Shape.Square(1.15))

    for (shape in shapes) {
        println("${shape.javaClass.name} Area: -> ${shape.area}")
    }
}
