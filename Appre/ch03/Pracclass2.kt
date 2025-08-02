package com.prac.pracclass2

class TShirt(val size: String, val color: String, val price: Double, val image: String? = null) {
    override fun toString() = "TShirt[size: $size, $color, $price, ${
    image ?: ""
  }]"
}

data class User(val name: String, val email: String, val chart: ShoppingChart)

data class Address(val name: String, val city: String, val zip_code: String)

data class ShoppingChart(val address: Address, val item: MutableList<TShirt>)

fun main() {
    val ankara_tshit = TShirt("L", "blue", 2.1, "Lion-Head-Image")
    println(ankara_tshit)
    val polo_tshit = TShirt("L", "blue", 2.1, null)
    println(polo_tshit)

    val john =
            User(
                    "john",
                    "johnApp@gmail.com",
                    ShoppingChart(
                            Address("dundee", "angus", "dd2-2lp"),
                            mutableListOf(
                                    TShirt("XXL", "Grey", 3.21, "Leopard-figure"),
                                    TShirt("XL", "black", 1.56)
                            )
                    )
            )
    println(john)
}
