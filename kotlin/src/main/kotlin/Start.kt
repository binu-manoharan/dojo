package samples

import java.lang.Math.abs
import java.util.*

fun greetingMessage(): String {
    return "hello world!"
}

fun maxIndexOf(elements: IntArray): Int? {
    return elements.withIndex().maxBy { it.value }?.index
//    return elements.foldIndexed(0) { index, acc, element ->
//        if (element > elements[acc])
//            index
//        else
//            acc
//    }
//    return elements.mapIndexed { index, elem -> Pair(index, elem)}
//            .reversed()
//            .maxBy { it.second }!!.first
}


fun runs(elements: IntArray): Int {
    return elements.fold(intArrayOf(), { acc, element ->
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
            object : Comparator<Int> {
                override fun compare(x: Int, y: Int): Int = y - x
            }
    )
    list.sortWith(Comparator { x, y -> y - x })
    return list.sortedDescending()
}

fun closestToZero(elements: IntArray): Int? {
    return elements.map { Pair(it, Math.abs(it)) }
            .groupBy { it.second }
            .minBy { it.key }
            ?.value
            ?.maxBy { it.first }
            ?.first
            ?: 0
}


// A single line providing the move to be made: N NE E SE S SW W or NW
fun getDirectionsForThor(powerX: Int, powerY: Int, initThorX: Int, initThorY: Int): List<String> {
    val absY = abs(powerY - initThorY)
    val absX = abs(powerX - initThorX)
    val ns: List<String> = when {
        powerY > initThorY -> generateSequence { "S" }.take(absY).toList()
        powerY < initThorY -> generateSequence { "N" }.take(absY).toList()
        else -> emptyList()
    }
    val we: List<String> = when {
        powerX > initThorX -> generateSequence { "E" }.take(absX).toList()
        powerX < initThorX -> generateSequence { "W" }.take(absX).toList()
        else -> emptyList()
    }

    when {
        ns.size > we.size -> return ns.zip(we).map { it.first + it.second } + ns.subList(we.size, ns.size)
        we.size > ns.size -> return ns.zip(we).map { it.first + it.second } + we.subList(ns.size, we.size)
        else -> return ns.zip(we).map { it.first + it.second }
    }
}

fun main(args: Array<String>) {
    generateSequence { 'a' }.take(4).forEach { println(it) }
}