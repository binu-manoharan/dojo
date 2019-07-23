package samples

import java.util.*

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

fun findPairless(elements: IntArray): Int {
    return elements.reduce { a, b -> a xor b }
}

fun sortDescending(): List<Int> {
    val list = arrayListOf(1, 5, 2)
    list.sortDescending()
    Collections.sort(
            list,
            object: Comparator<Int> {
                override fun compare(x: Int, y: Int): Int = y - x
            }
    )
    list.sortWith(Comparator { x, y -> y - x })
    return list.sortedDescending()
}