fun main(args: Array<String>) {
    val maxPalindrome = (0 until 1000).flatMap {
        n -> (0 until 1000).map {
            c -> n*c
	}
    }.filter {isPalindromeNumber(it)}
    .max()

    println(maxPalindrome)
    
}

fun isPalindromeNumber(num: Int): Boolean {
    val numStr = num.toString()
    return numStr == numStr.reversed()
}