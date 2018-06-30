import lib.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
	println((1..1_000_000).fold (Pair(0L, 0)) { acc, i -> numWithLargerCollatz(i.toLong(), acc) })
}

fun numWithLargerCollatz(num: Long, prevMax: Pair<Long, Int>): Pair<Long, Int> {
	val numSize = collatz(num).size
	val prevMaxSize = prevMax.second

	if (numSize > prevMaxSize) {
		return Pair(num, numSize)
	} else {
		return prevMax
	}
}

fun collatz(num: Long): List<Long> {
	if (num == 1L) {
	 	return listOf(1)
	} else if (num % 2 == 0L) {
		return listOf(num) + collatz(num / 2)
	} else {
		return listOf(num) + collatz(3 * num + 1)
	}
}



