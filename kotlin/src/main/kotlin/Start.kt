package samples

fun greetingMessage(): String {
    return "hello world!"
}

fun maxIndexOf(elements: IntArray): Int? {
    return elements.mapIndexed { index, elem -> Pair(index, elem)}
            .reversed()
            .maxBy { it.second }!!.first
}


fun runs(elements: IntArray): Int {
    return elements.fold(intArrayOf(), {
        acc, element ->
            val elementToInsert: Int? = when (val size = acc.size) {
                0 -> element
                else -> if (acc[size - 1] != element) element else null
            }
            if (elementToInsert == null) acc else acc.plus(elementToInsert)
    }).count()
}

fun isPalindrome(testString: String): Boolean {
    return testString.reversed().equals(testString)
}