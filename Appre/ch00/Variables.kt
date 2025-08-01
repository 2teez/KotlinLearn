fun main() {
    val date = Triple("August", 1, 2025)
    val month = date.first
    val day = date.second
    val year = date.third

    println("The date is on the ${day}, $month and $year")
    //
    val coordinate = 2 to 3
    val row = coordinate.first
    val column = coordinate.second

    println("Coordinate are $row and $column")
    //
    // using if expression
    val myAge = 19
    val isTeenager =
            if (myAge < 20 || myAge > 12) {
                "is a teenager"
            } else {
                "is not a teenager"
            }
    println("$myAge $isTeenager")
    // using a when expression
    println(
            "$myAge ${
        when (myAge){
            in 12..19 -> "is a teenager"
            else -> "is not a teenger"
        }
        }"
    )
}
