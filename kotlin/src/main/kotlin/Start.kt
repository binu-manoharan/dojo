package samples

fun greetingMessage(): String {
    return "hello world!"
}

fun maxIndexOf(elems: IntArray): Int? {
    return elems.mapIndexed { index, elem -> Pair(index, elem)}
            .reversed()
            .maxBy { it.second }!!.first
}