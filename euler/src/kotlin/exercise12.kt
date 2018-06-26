import lib.*

fun main(args: Array<String>) {
	//val sequence: Sequence<Int> = generateSequence(1) { it + 1 }.map { sum(it) }
	//println(sequence.find {numDivisors(it) == 3})

	println(atleastNumDivisors(500))
	//println(divisors(28))
	println(divisors(76576500))
	
}

fun sum(num: Int): Int = (1..num).sum()

fun numDivisors(num: Int): Int  = (1..num).filter { isPerfectlyDivisible(num, it) }.size

fun divisors(num: Int): List<Int> {
	val divisorsTillRoot = (1..(Math.sqrt(num.toDouble()).toInt())).filter { isPerfectlyDivisible(num, it) }.toList()
	return divisorsTillRoot + divisorsTillRoot.map {num / it}
}

fun atleastNumDivisors(num: Int): Int {
	var sum = 0;
	for (i in 1..Integer.MAX_VALUE) {

		sum = i + sum		
//		println(sum)
		val numDivisors = divisors(sum).size
		if (numDivisors > num) {
			return sum
		}


	}
	return -1
}
