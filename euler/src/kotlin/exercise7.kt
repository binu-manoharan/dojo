import lib.*

fun main(args: Array<String>) {
	val sequence = generateSequence(2) {it + 1}.filter {x -> isPrime(x)}
	println (sequence.take(10001).toList().last())
}
