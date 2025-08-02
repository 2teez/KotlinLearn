fun main() {
    val pp = mutableMapOf("c" to 12, "c++" to 11, "java" to 9, "rust" to 7)
    println(pp)

    // pp["dorcas"] = 5
    pp.put("ruby", 5)
    println(pp)
    val mel = "python" to 3
    pp += mel
    pp.pp()

    val langs = mutableListOf("java", "clojure")
    langs += "groovy"
    langs.toTypedArray().joinToString().pp()
    //
    val states = mapOf("NY" to "New York", "CA" to "California")
    println(eigthLongerString(states))
}

fun eigthLongerString(map: Map<String, String>): String {
    val names = mutableListOf<String>()
    for (name in map.values) {
        if (name.length > 8) names.add(name)
    }

    return names.toTypedArray().joinToString()
}

fun Any?.pp() {
    println(this)
}
