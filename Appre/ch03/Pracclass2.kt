package com.prac.pracclass2

class TShirt(val size: String, val color: String, val price: Double, val image: String?) {
    override fun toString() = "TShirt[size: $size, $color, $price, ${
    image ?: ""
  }]"
}

data class User(val name: String, val email: String, val chart: ShoppingChart)

data class ShoppingChart(val item: MutableList<TShirt>)

fun main() {
    val ankara_tshit = TShirt("L", "blue", 2.1, "Lion-Head-Image")
    println(ankara_tshit)
    val polo_tshit = TShirt("L", "blue", 2.1, null)
    println(polo_tshit)
}
