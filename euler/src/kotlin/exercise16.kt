import lib.*
import java.math.BigInteger

fun main(args: Array<String>) {
	val twoPow1000 = powOf2(1000)
	println(twoPow1000)

	val sumOfNumbers = twoPow1000
			.toString()
			.map {c -> c.toString().toInt()}
			.fold (0) { acc, i -> acc + i }
	println(sumOfNumbers)
	
}

fun powOf2(num: Int): BigInteger {
	var initVal = BigInteger.valueOf(2)
	for (i in 2..num) {
		initVal = initVal * BigInteger.valueOf(2)
	}
	
	return initVal
}
