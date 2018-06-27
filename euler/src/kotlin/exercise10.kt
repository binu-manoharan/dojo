import lib.*

fun main(args: Array<String>) {
	val sequence = generateSequence(2) {it + 1}.filter {isPrime(it)}
	println(sequence.takeWhile {it < 2_000_000L}.fold (0L) { x, y -> x + y } )
}


