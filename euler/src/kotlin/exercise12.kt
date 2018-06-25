import lib.*

fun main(args: Array<String>) {
	val sequence: Sequence<Int> = generateSequence(1) { it + 1 }.map { sum(it) }
	println(sequence.find {numDivisors(it) == 3})
}

fun sum(num: Int): Int = (1..num).sum()

fun numDivisors(num: Int): Int  = (1..num).filter { isPerfectlyDivisible(num, it) }.size


