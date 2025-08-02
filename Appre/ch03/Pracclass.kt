class Person(var firstName: String, var lastName: String) {
    val fullName
        get() = "$firstName $lastName"
}

data class User(val name: String) {
    val movies: MutableMap<String, MovieList> = mutableMapOf()

    fun addList(movieList: MovieList) {
        movies.put(movieList.name, movieList)
    }
}

class MovieList(val name: String, val titles: MutableList<String>) {
    override fun toString() = titles.joinToString()
}

fun main() {
    val clojure = Person(firstName = "clojure", lastName = "jvm")
    println(clojure.fullName)

    //
    val jane = User(name = "jane")
    jane.addList(
            movieList =
                    MovieList(
                            "romantic",
                            titles = mutableListOf("love-boats", "10 and half men", "love-island")
                    )
    )
    jane.addList(
            MovieList("crime", mutableListOf("criminals-mind", "bone-collector", "dark-knight"))
    )
    println(jane.movies)
    val john = User(name = "john")
    john.addList(
            MovieList("war", mutableListOf("World-War-I", "World-War-II", "spartacus", "Rome"))
    )
    println(john.movies)
    jane.movies["crime"].let { john.addList(jane.movies["crime"]!!) }
    jane.addList(john.movies["war"]!!)
    println(jane.movies)
    jane.movies["war"]?.titles?.add("pearl-harbour")
    println(john.movies)
    println(jane.movies)
}
