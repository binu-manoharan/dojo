fun main(args: Array<String>) {
	// println (sumOfSquares(10))
	// println (squareOfSum(10))
	println (diff(100))
}

fun diff(num: Int) = squareOfSum(num) - sumOfSquares(num)

fun sumOfSquares(num: Int): Int = when (num) {
	in (Int.MIN_VALUE..0) -> 0
	else -> num * num + sumOfSquares(num - 1)
}

fun squareOfSum(num: Int): Int = when (num) {
	in (Int.MIN_VALUE..0) -> 0
	else -> Math.pow((1..num).sum().toDouble(), 2.toDouble()).toInt()
}
