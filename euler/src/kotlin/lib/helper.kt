package lib

fun isPrime(num: Int): Boolean {
	val possibleDivisors = (2..(Math.round(Math.sqrt(num.toDouble())).toInt())).toList()
	val divisors = possibleDivisors.filter {x: Int -> isPerfectlyDivisible(num, x)}
        return divisors.size == 0
}

fun isPerfectlyDivisible(num: Int, divisor: Int): Boolean = num % divisor == 0
